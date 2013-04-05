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

    @Query("select new org.celllife.ohsc.domain.datamart.ClinicAverage(subDistrictName, subDistrictShortName, " +
            "clinicCode, clinicShortName, avg(staffAttitudeRating), avg(cleanlinessRating), " +
            "avg(waitingTimesRating), avg(drugAvailabilityRating), avg(infectionControlRating), " +
            "avg(safeAndSecureCareRating) ) from DataMartRating " +
            "where subDistrictName = :subDistrictName " +
            "group by subDistrictName, subDistrictShortName, clinicCode, clinicShortName")
    Iterable<ClinicAverage> findClinicAveragesBySubDistrictName(@Param("subDistrictName") String subDistrictName);

    @Query("select new org.celllife.ohsc.domain.datamart.SubDistrictAverage(districtName, districtShortName, " +
            "subDistrictName, subDistrictShortName, avg(staffAttitudeRating), avg(cleanlinessRating), " +
            "avg(waitingTimesRating), avg(drugAvailabilityRating), avg(infectionControlRating), " +
            "avg(safeAndSecureCareRating) ) from DataMartRating " +
            "where districtName = :districtName " +
            "group by districtName, districtShortName, subDistrictName, subDistrictShortName")
    Iterable<SubDistrictAverage> findSubDistrictAveragesByDistrictName(@Param("districtName") String districtName);

    @Query("select new org.celllife.ohsc.domain.datamart.DistrictAverage(provinceName, provinceShortName, " +
            "districtName, districtShortName, avg(staffAttitudeRating), avg(cleanlinessRating), " +
            "avg(waitingTimesRating), avg(drugAvailabilityRating), avg(infectionControlRating), " +
            "avg(safeAndSecureCareRating) ) from DataMartRating " +
            "where provinceName = :provinceName " +
            "group by provinceName, provinceShortName, districtName, districtShortName")
    Iterable<DistrictAverage> findDistrictAveragesByProvinceName(@Param("provinceName") String provinceName);

    @Query("select new org.celllife.ohsc.domain.datamart.ProvinceAverage(provinceName, provinceShortName, " +
            "avg(staffAttitudeRating), avg(cleanlinessRating), avg(waitingTimesRating), avg(drugAvailabilityRating), " +
            "avg(infectionControlRating), avg(safeAndSecureCareRating) ) from DataMartRating " +
            "group by provinceName, provinceShortName")
    Iterable<ProvinceAverage> findProvinceAverages();

}
