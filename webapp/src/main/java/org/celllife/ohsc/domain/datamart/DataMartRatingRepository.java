package org.celllife.ohsc.domain.datamart;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-02
 * Time: 11h10
 */
@RestResource(path = "datamartratings")
public interface DataMartRatingRepository extends PagingAndSortingRepository<DataMartRating, String> {

    @Query("select new org.celllife.ohsc.domain.datamart.ClinicAverageDTO(clinicCode, clinicShortName, subDistrictName, " +
            "subDistrictShortName, districtName, districtShortName, provinceName, provinceShortName, countryName, " +
            "countryShortName,  avg(staffAttitudeRating), avg(cleanlinessRating), avg(waitingTimesRating), " +
            "avg(drugAvailabilityRating),  avg(infectionControlRating), avg(safeAndSecureCareRating), count(*)) " +
            "from DataMartRating " +
            "where (submissionDate between :startDate and :endDate)" +
            "and subDistrictName = :subDistrictName " +
            "group by subDistrictName, subDistrictShortName, clinicCode, clinicShortName")
    Iterable<ClinicAverageDTO> findClinicAveragesBySubDistrictName(@Param("subDistrictName") String subDistrictName, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select new org.celllife.ohsc.domain.datamart.SubDistrictAverageDTO(subDistrictName, " +
            "subDistrictShortName, districtName, districtShortName, provinceName, provinceShortName, countryName,  " +
            "countryShortName, avg(staffAttitudeRating), avg(cleanlinessRating), avg(waitingTimesRating), " +
            "avg(drugAvailabilityRating), avg(infectionControlRating), avg(safeAndSecureCareRating), count(*)) " +
            "from DataMartRating " +
            "where (submissionDate between :startDate and :endDate)" +
            "and districtName = :districtName " +
            "group by districtName, districtShortName, subDistrictName, subDistrictShortName")
    Iterable<SubDistrictAverageDTO> findSubDistrictAveragesByDistrictName(@Param("districtName") String districtName, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select new org.celllife.ohsc.domain.datamart.DistrictAverageDTO(districtName, districtShortName, " +
            "provinceName, provinceShortName, countryName, countryShortName,  avg(staffAttitudeRating), " +
            "avg(cleanlinessRating), avg(waitingTimesRating), avg(drugAvailabilityRating), " +
            "avg(infectionControlRating),  avg(safeAndSecureCareRating), count(*)) from DataMartRating " +
            "where (submissionDate between :startDate and :endDate)" +
            "and provinceName = :provinceName " +
            "group by provinceName, provinceShortName, districtName, districtShortName")
    Iterable<DistrictAverageDTO> findDistrictAveragesByProvinceName(@Param("provinceName") String provinceName, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select new org.celllife.ohsc.domain.datamart.ProvinceAverageDTO(provinceName, provinceShortName, " +
            "countryName, countryShortName, avg(staffAttitudeRating), avg(cleanlinessRating), " +
            "avg(waitingTimesRating), avg(drugAvailabilityRating), avg(infectionControlRating), " +
            "avg(safeAndSecureCareRating), count(*)) " +
            "from DataMartRating " +
            "where (submissionDate between :startDate and :endDate)" +
            "and countryName = :countryName " +
            "group by provinceName, provinceShortName")
    Iterable<ProvinceAverageDTO> findProvinceAveragesByCountryName(@Param("countryName") String countryName, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select distinct new org.celllife.ohsc.domain.datamart.TotalClinicsMonitoredDTO(provinceName, provinceShortName, " +
            "countryName, countryShortName, count(distinct clinicCode))" +
            "from DataMartRating " +
            "where countryName = :countryName " +
            "group by provinceName, provinceShortName")
    Iterable<TotalClinicsMonitoredDTO> findTotalClinicsMonitoredByProvince(@Param("countryName") String countryName);

    @Query("select new org.celllife.ohsc.domain.datamart.ClinicIndividualRatingDTO(clinicCode, clinicShortName, " +
    		"subDistrictName, subDistrictShortName, districtName, districtShortName," +
    		"provinceName, provinceShortName, countryName, countryShortName," +
    		"msisdn, submissionDate," +
    		"staffAttitudeRating, cleanlinessRating, waitingTimesRating," +
    		"drugAvailabilityRating, infectionControlRating, safeAndSecureCareRating) " +
            "from DataMartRating dmt " +
            "where (dmt.submissionDate between :startDate and :endDate) " +
            "and dmt.clinicCode = :clinicCode " +
            "group by dmt.clinicCode, dmt.clinicShortName, dmt.msisdn")    
    Page<ClinicIndividualRatingDTO> findIndividualRatingsByClinic(@Param("clinicCode") String clinicCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable p);
}
