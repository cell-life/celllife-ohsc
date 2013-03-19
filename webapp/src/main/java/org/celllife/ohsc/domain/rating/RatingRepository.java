package org.celllife.ohsc.domain.rating;

import org.celllife.ohsc.framework.logging.LogLevel;
import org.celllife.ohsc.framework.logging.Loggable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 14h15
 */
@Loggable(LogLevel.DEBUG)
@RestResource(path = "ratings")
public interface RatingRepository extends PagingAndSortingRepository<Rating, Long> {

    @Query("select c.shortName, q.domainCode, avg(q.answer.value), count(*) " +
            "from Rating r " +
            "join r.clinic c " +
            "join r.questions q " +
            "group by c.shortName, q.domainCode")
    public List<Object[]> findClinicAverages();

    @Query("select sd.shortName, q.domainCode, avg(q.answer.value), count(*) " +
            "from Rating r " +
            "join r.clinic c " +
            "join c.subDistrict sd " +
            "join r.questions q " +
            "group by sd.shortName, q.domainCode")
    public List<Object[]> findSubDistrictAverages();
}
