package org.celllife.ohsc.domain.district;

import org.celllife.ohsc.framework.logging.LogLevel;
import org.celllife.ohsc.framework.logging.Loggable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 14h15
 */
@Loggable(LogLevel.DEBUG)
@RestResource(path = "districts")
public interface DistrictRepository extends PagingAndSortingRepository<District, Long> {

    District findByExternalId(String externalId);

}
