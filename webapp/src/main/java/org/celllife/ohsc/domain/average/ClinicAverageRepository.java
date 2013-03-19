package org.celllife.ohsc.domain.average;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 14h15
 */
@RestResource(path = "clinicAverages")
public interface ClinicAverageRepository extends PagingAndSortingRepository<ClinicAverage, Long> {

    ClinicAverage findByClinicCode(@Param("code") String code);

}