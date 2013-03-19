package org.celllife.ohsc.application.average;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ILock;
import org.celllife.ohsc.domain.average.ClinicAverage;
import org.celllife.ohsc.domain.average.ClinicAverageRepository;
import org.celllife.ohsc.domain.clinic.Clinic;
import org.celllife.ohsc.domain.rating.Question;
import org.celllife.ohsc.domain.rating.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 18h27
 */
@Service
public class ClinicAverageApplicationServiceImpl implements ClinicAverageApplicationService {

    @Autowired
    private ClinicAverageRepository clinicAverageRepository;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    public void addRating(Rating rating) {

        String clinicLockString = "Clinic[" + rating.getClinic().getCode() + "]";
        ILock lock = hazelcastInstance.getLock(clinicLockString);

        if (getLock(lock)) {
            try {

                doAddRating(rating);

            } finally {
                lock.unlock();
            }
        } else {
            throw new RuntimeException("Could not acquire lock for: " + clinicLockString);
        }
    }

    private boolean getLock(ILock lock)  {

        try {
            return lock.tryLock(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void doAddRating(Rating rating) {

        Clinic clinic = rating.getClinic();

        ClinicAverage clinicAverage = clinicAverageRepository.findByClinicCode(clinic.getCode());

        if (clinicAverage == null) {
            clinicAverage = newClinicAverage(rating, clinic);
        } else {
            clinicAverage = updateClinicAverage(rating, clinicAverage);
        }

        clinicAverageRepository.save(clinicAverage);
    }

    private ClinicAverage updateClinicAverage(Rating rating, ClinicAverage clinicAverage) {

        Integer oldTotalResponses = clinicAverage.getTotalResponses();

        for (Question question : rating.getQuestions()) {

            String domainCode = question.getDomainCode();

            Double oldDomainAverage = clinicAverage.getDomainAverage(domainCode);

            Integer newValue = question.getRatingValue();

            Double newDomainAverage = calculateNewAverage(oldDomainAverage, oldTotalResponses, newValue);

            clinicAverage.setDomainAverage(domainCode, newDomainAverage);
        }

        clinicAverage.incrementTotalResponses();

        return clinicAverage;
    }

    private ClinicAverage newClinicAverage(Rating rating, Clinic clinic) {

        ClinicAverage clinicAverage = new ClinicAverage();
        clinicAverage.setClinic(clinic);

        for (Question question : rating.getQuestions()) {

            String domainCode = question.getDomainCode();

            Integer ratingValue = question.getRatingValue();

            clinicAverage.setDomainAverage(domainCode, ratingValue.doubleValue());
        }

        clinicAverage.incrementTotalResponses();

        return clinicAverage;
    }

    /*
     * http://jvminside.blogspot.com/2010/01/incremental-average-calculation.html
     */
    static Double calculateNewAverage(Double oldAverage, Integer oldCount, Integer newValue) {
        return oldAverage + ( ( newValue - oldAverage ) / ( oldCount + 1 ) );
    }
}
