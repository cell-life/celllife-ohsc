package org.celllife.ohsc.domain.ratingdatamart;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-02
 * Time: 11h10
 */
@RestResource(path = "ratingdatamart")
public interface RatingDataMartRepository extends PagingAndSortingRepository<RatingDataMart, String> {
}
