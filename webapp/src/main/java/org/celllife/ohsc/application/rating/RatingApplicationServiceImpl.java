package org.celllife.ohsc.application.rating;

import static org.celllife.ohsc.domain.rating.Domain.CLEANLINESS;
import static org.celllife.ohsc.domain.rating.Domain.DRUG_AVAILABILITY;
import static org.celllife.ohsc.domain.rating.Domain.INFECTION_CONTROL;
import static org.celllife.ohsc.domain.rating.Domain.SAFE_AND_SECURE_CARE;
import static org.celllife.ohsc.domain.rating.Domain.STAFF_ATTITUDE;
import static org.celllife.ohsc.domain.rating.Domain.WAITING_TIMES;

import java.util.Date;

import org.celllife.ohsc.domain.clinic.Clinic;
import org.celllife.ohsc.domain.clinic.ClinicRepository;
import org.celllife.ohsc.domain.country.Country;
import org.celllife.ohsc.domain.datamart.ClinicIndividualRatingDTO;
import org.celllife.ohsc.domain.datamart.DataMartRating;
import org.celllife.ohsc.domain.datamart.DataMartRatingBuilder;
import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.district.District;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.rating.Rating;
import org.celllife.ohsc.domain.rating.RatingRepository;
import org.celllife.ohsc.domain.subdistrict.SubDistrict;
import org.celllife.ohsc.framework.logging.LogLevel;
import org.celllife.ohsc.framework.logging.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-02
 * Time: 11h14
 */
@Service
public final class RatingApplicationServiceImpl implements RatingApplicationService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private DataMartRatingRepository ratingDataMartRepository;

    @Override
    @Loggable(value = LogLevel.DEBUG, exception = LogLevel.ERROR)
    public void save(Rating rating) {

        rating = ratingRepository.save(rating);

        if (rating.isComplete()) {
            insertToRatingDataMart(rating);
        }
    }
    
	@Override
	@Loggable(value = LogLevel.DEBUG, exception = LogLevel.ERROR)
	public Iterable<ClinicIndividualRatingDTO> findIndividualRatingsByClinic(String clinicCode, Date startDate, Date endDate) {
		return ratingDataMartRepository.findIndividualRatingsByClinic(clinicCode, startDate, endDate);
	}

    private void insertToRatingDataMart(Rating rating) {

        Clinic clinic = clinicRepository.findOneByCode(rating.getClinicCode());

        SubDistrict subDistrict = clinic.getSubDistrict();

        District district = subDistrict.getDistrict();

        Province province = district.getProvince();

        Country country = province.getCountry();

        DataMartRating dataMartRating = new DataMartRatingBuilder()
                .setUssdSessionId(rating.getUssdSession().getId())
                .setClinicCode(rating.getClinicCode())
                .setClinicShortName(clinic.getShortName())
                .setSubDistrictName(subDistrict.getName())
                .setSubDistrictShortName(subDistrict.getShortName())
                .setDistrictName(district.getName())
                .setDistrictShortName(district.getShortName())
                .setProvinceName(province.getName())
                .setProvinceShortName(province.getShortName())
                .setCountryName(country.getName())
                .setCountryShortName(country.getShortName())
                .setMsisdn(rating.getUser().getMsisdn())
                .setStaffAttitudeRating(rating.getRatingForDomain(STAFF_ATTITUDE))
                .setCleanlinessRating(rating.getRatingForDomain(CLEANLINESS))
                .setWaitingTimesRating(rating.getRatingForDomain(WAITING_TIMES))
                .setDrugAvailabilityRating(rating.getRatingForDomain(DRUG_AVAILABILITY))
                .setInfectionControlRating(rating.getRatingForDomain(INFECTION_CONTROL))
                .setSafeAndSecureCareRating(rating.getRatingForDomain(SAFE_AND_SECURE_CARE))
                .setSubmissionDate(rating.getUssdSession().getEndDateTime())
                .getDataMartRating();

        ratingDataMartRepository.save(dataMartRating);
    }
}
