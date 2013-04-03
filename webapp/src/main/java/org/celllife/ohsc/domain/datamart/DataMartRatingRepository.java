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

    @Query("select clinic, avg(staffAttitudeRating) as staffAttitudeAverage from DataMartRating where subDistrict = :subDistrict group by clinic")
    Iterable<ClinicAverages> findAllClinicAveragesBySubDistrict(@Param("subDistrict") String subDistrict);

}
