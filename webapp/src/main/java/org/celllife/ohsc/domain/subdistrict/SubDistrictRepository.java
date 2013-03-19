package org.celllife.ohsc.domain.subdistrict;

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
@RestResource(path = "subDistricts")
public interface SubDistrictRepository extends PagingAndSortingRepository<SubDistrict, Long> {

    SubDistrict findByExternalId(String externalId);

}
