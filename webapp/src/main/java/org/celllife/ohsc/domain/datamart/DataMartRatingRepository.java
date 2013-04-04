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

    @Query("select subDistrictName as subDistrictName, " +
            "subDistrictShortName as subDistrictShortName, " +
            "clinicCode as clinicCode, " +
            "clinicShortName as clinicShortName, " +
            "avg(staffAttitudeRating) as staffAttitudeAverage, " +
            "avg(cleanlinessRating) as cleanlinessAverage, " +
            "avg(waitingTimesRating) as waitingTimesAverage, " +
            "avg(drugAvailabilityRating) as drugAvailabilityAverage, " +
            "avg(infectionControlRating) as infectionControlAverage, " +
            "avg(safeAndSecureCareRating) as safeAndSecureCareAverage " +
            "from DataMartRating " +
            "where subDistrictName = :subDistrictName " +
            "group by subDistrictName, subDistrictShortName, clinicCode , clinicShortName")
    Iterable<ClinicAverage> findAllClinicAveragesBySubDistrictName(@Param("subDistrictName") String subDistrictName);

}
