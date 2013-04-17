package org.celllife.ohsc.domain.datamart;

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
            "where subDistrictName = :subDistrictName " +
            "group by subDistrictName, subDistrictShortName, clinicCode, clinicShortName")
    Iterable<ClinicAverageDTO> findClinicAveragesBySubDistrictName(@Param("subDistrictName") String subDistrictName);

    @Query("select new org.celllife.ohsc.domain.datamart.SubDistrictAverageDTO(subDistrictName, " +
            "subDistrictShortName, districtName, districtShortName, provinceName, provinceShortName, countryName,  " +
            "countryShortName, avg(staffAttitudeRating), avg(cleanlinessRating), avg(waitingTimesRating), " +
            "avg(drugAvailabilityRating), avg(infectionControlRating), avg(safeAndSecureCareRating), count(*)) " +
            "from DataMartRating " +
            "where districtName = :districtName " +
            "group by districtName, districtShortName, subDistrictName, subDistrictShortName")
    Iterable<SubDistrictAverageDTO> findSubDistrictAveragesByDistrictName(@Param("districtName") String districtName);

    @Query("select new org.celllife.ohsc.domain.datamart.DistrictAverageDTO(districtName, districtShortName, " +
            "provinceName, provinceShortName, countryName, countryShortName,  avg(staffAttitudeRating), " +
            "avg(cleanlinessRating), avg(waitingTimesRating), avg(drugAvailabilityRating), " +
            "avg(infectionControlRating),  avg(safeAndSecureCareRating), count(*)) from DataMartRating " +
            "where provinceName = :provinceName " +
            "group by provinceName, provinceShortName, districtName, districtShortName")
    Iterable<DistrictAverageDTO> findDistrictAveragesByProvinceName(@Param("provinceName") String provinceName);

    @Query("select new org.celllife.ohsc.domain.datamart.ProvinceAverageDTO(provinceName, provinceShortName, " +
            "countryName, countryShortName, avg(staffAttitudeRating), avg(cleanlinessRating), " +
            "avg(waitingTimesRating), avg(drugAvailabilityRating), avg(infectionControlRating), " +
            "avg(safeAndSecureCareRating), count(*)) " +
            "from DataMartRating " +
            "where countryName = :countryName " +
            "group by provinceName, provinceShortName")
    Iterable<ProvinceAverageDTO> findProvinceAveragesByCountryName(@Param("countryName") String countryName);

    @Query("select new org.celllife.ohsc.domain.datamart.TotalClinicsMonitoredDTO(provinceName, provinceShortName, " +
            "countryName, countryShortName, count(*))" +
            "from DataMartRating " +
            "where countryName = :countryName " +
            "group by provinceName, provinceShortName")
    Iterable<TotalClinicsMonitoredDTO> findTotalClinicsMonitoredByProvince(@Param("countryName") String countryName);

}
