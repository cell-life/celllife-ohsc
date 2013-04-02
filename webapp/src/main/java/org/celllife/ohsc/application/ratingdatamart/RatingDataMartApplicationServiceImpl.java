package org.celllife.ohsc.application.ratingdatamart;

import org.celllife.ohsc.domain.clinic.Clinic;
import org.celllife.ohsc.domain.clinic.ClinicRepository;
import org.celllife.ohsc.domain.district.District;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.rating.Rating;
import org.celllife.ohsc.domain.rating.RatingRepository;
import org.celllife.ohsc.domain.ratingdatamart.RatingDataMart;
import org.celllife.ohsc.domain.ratingdatamart.RatingDataMartBuilder;
import org.celllife.ohsc.domain.ratingdatamart.RatingDataMartRepository;
import org.celllife.ohsc.domain.subdistrict.SubDistrict;
import org.celllife.ohsc.framework.logging.LogLevel;
import org.celllife.ohsc.framework.logging.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static org.celllife.ohsc.domain.rating.Domain.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-02
 * Time: 11h14
 */
@Service
public final class RatingDataMartApplicationServiceImpl implements RatingDataMartApplicationService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private RatingDataMartRepository ratingDataMartRepository;

    @Scheduled(fixedDelay = (1000 * 60 * 1))
    @Loggable(value = LogLevel.INFO, exception = LogLevel.ERROR)
    public void insertRatingsIntoDataMart() {

        Iterable<Rating> ratings = ratingRepository.findAll();

        for (Rating rating : ratings) {

            if (!rating.isComplete()) {
                continue;
            }

            Clinic clinic = clinicRepository.findOneByCode(rating.getClinicCode());

            SubDistrict subDistrict = clinic.getSubDistrict();

            District district = subDistrict.getDistrict();

            Province province = district.getProvince();

            RatingDataMart ratingDataMart = new RatingDataMartBuilder()
                    .setUssdSessionId(rating.getUssdSession().getId())
                    .setClinic(rating.getClinicCode())
                    .setDistrict(rating.getLanguageCode())
                    .setClinic(clinic.getName())
                    .setSubDistrict(subDistrict.getName())
                    .setDistrict(district.getName())
                    .setProvince(province.getName())
                    .setStaffAttitudeRating(rating.getRatingForDomain(STAFF_ATTITUDE))
                    .setCleanlinessRating(rating.getRatingForDomain(CLEANLINESS))
                    .setWaitingTimesRating(rating.getRatingForDomain(WAITING_TIMES))
                    .setDrugAvailabilityRating(rating.getRatingForDomain(DRUG_AVAILABILITY))
                    .setInfectionControlRating(rating.getRatingForDomain(INFECTION_CONTROL))
                    .setSafeAndSecureCareRating(rating.getRatingForDomain(SAFE_AND_SECURE_CARE))
                    .getRatingDataMart();

            ratingDataMartRepository.save(ratingDataMart);
        }
    }
}
