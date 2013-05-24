package org.celllife.ohsc.application.rating;

import static org.celllife.ohsc.domain.rating.Domain.CLEANLINESS;
import static org.celllife.ohsc.domain.rating.Domain.DRUG_AVAILABILITY;
import static org.celllife.ohsc.domain.rating.Domain.INFECTION_CONTROL;
import static org.celllife.ohsc.domain.rating.Domain.SAFE_AND_SECURE_CARE;
import static org.celllife.ohsc.domain.rating.Domain.STAFF_ATTITUDE;
import static org.celllife.ohsc.domain.rating.Domain.WAITING_TIMES;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.celllife.ohsc.domain.clinic.Clinic;
import org.celllife.ohsc.domain.clinic.ClinicRepository;
import org.celllife.ohsc.domain.country.Country;
import org.celllife.ohsc.domain.datamart.ClinicIndividualRatingDTO;
import org.celllife.ohsc.domain.datamart.ClinicIndividualRatingPageDTO;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-02
 * Time: 11h14
 */
@Service
public final class RatingApplicationServiceImpl implements RatingApplicationService {
	
	private static Logger log = LoggerFactory.getLogger(RatingApplicationServiceImpl.class); 

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
	public ClinicIndividualRatingPageDTO findIndividualRatingsByClinic(
			String clinicCode, Date startDate, Date endDate,
			Integer iDisplayStart, Integer iDisplayLength, String sSearch, Integer iSortingCols,
			Integer iSortCol_0, Integer iSortCol_1,	Integer iSortCol_2,	Integer iSortCol_3,	Integer iSortCol_4,	Integer iSortCol_5,	Integer iSortCol_6,	Integer iSortCol_7,
			String sSortDir_0, String sSortDir_1, String sSortDir_2, String sSortDir_3, String sSortDir_4, String sSortDir_5, String sSortDir_6, String sSortDir_7,
			String sEcho) {

		// create the page request with sorting and page specified
		Sort sort = null;
		if (iSortingCols != null && iSortingCols > 0) {
			sort = createClinicIndividualRatingSort(iSortCol_0, sSortDir_0);
			if (sort != null) {
				sort.and(createClinicIndividualRatingSort(iSortCol_1, sSortDir_1));
				sort.and(createClinicIndividualRatingSort(iSortCol_2, sSortDir_2));
				sort.and(createClinicIndividualRatingSort(iSortCol_3, sSortDir_3));
				sort.and(createClinicIndividualRatingSort(iSortCol_4, sSortDir_4));
				sort.and(createClinicIndividualRatingSort(iSortCol_5, sSortDir_5));
				sort.and(createClinicIndividualRatingSort(iSortCol_6, sSortDir_6));
				sort.and(createClinicIndividualRatingSort(iSortCol_7, sSortDir_7));
			}
		}
    	Pageable pageable = new PageRequest(iDisplayStart,iDisplayLength, sort);
    	
    	// get the data
    	log.debug("about to query for individual ratings. page="+pageable.getPageNumber()+" page size="+pageable.getPageSize()+" sort="+((PageRequest)pageable).getSort());
		Page<ClinicIndividualRatingDTO> page = ratingDataMartRepository.findIndividualRatingsByClinic(clinicCode, startDate, endDate, pageable);
		
		// translate to the correct format for the UI
		ClinicIndividualRatingPageDTO pageDTO = new ClinicIndividualRatingPageDTO();
		pageDTO.setClinicCode(clinicCode);
		pageDTO.setsEcho(sEcho);
		pageDTO.setiTotalDisplayRecords((int)page.getTotalElements()); // FIXME: haven't implemented filtering on search field
		pageDTO.setiTotalRecords((int)page.getTotalElements());
		Object[][] aaData = new Object[page.getNumberOfElements()][];
		Iterator<ClinicIndividualRatingDTO> it = page.iterator();
		int row = 0;
		while (it.hasNext()) {
			ClinicIndividualRatingDTO dto = it.next();
			if (row == 0) {
				pageDTO.setClinicShortName(dto.getClinicShortName());
				pageDTO.setCountryName(dto.getCountryName());
				pageDTO.setCountryShortName(dto.getCountryShortName());
				pageDTO.setDistrictName(dto.getDistrictName());
				pageDTO.setDistrictShortName(dto.getDistrictShortName());
				pageDTO.setProvinceName(dto.getProvinceName());
				pageDTO.setProvinceShortName(dto.getProvinceShortName());
				pageDTO.setSubDistrictName(dto.getSubDistrictName());
				pageDTO.setSubDistrictShortName(dto.getSubDistrictShortName());
			}
			aaData[row] = new Object[] { dto.getMsisdn(), 
					new SimpleDateFormat("dd MMM yyyy HH:mm:ss").format(dto.getSubmissionDate()), 
					dto.getStaffAttitudeRating(), dto.getCleanlinessRating(), dto.getWaitingTimesRating(), 
					dto.getSafeAndSecureCareRating(), dto.getInfectionControlRating(), dto.getDrugAvailabilityRating()};
			row++;
		}
		pageDTO.setAaData(aaData);

		return pageDTO;
	}
	
	private Sort createClinicIndividualRatingSort(Integer col, String dir) {
		String[] columns = new String[] { "msisdn", "msisdn", "staffAttitudeRating", "cleanlinessRating", "waitingTimesRating", "safeAndSecureCareRating", "infectionControlRating", "drugAvailabilityRating"};
		Sort sort = null;
		if (col != null && col >= 0) {
			sort = new Sort((dir.equals("asc") ? Direction.ASC : Direction.DESC), columns[col]);
		}
		return sort;
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
