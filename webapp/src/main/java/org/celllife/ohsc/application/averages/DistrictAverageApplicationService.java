package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.datamart.DistrictAverage;

import java.util.Collection;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 22h04
 */
public interface DistrictAverageApplicationService {

    Collection<DistrictAverage> findDistrictAveragesByProvince(String provinceName);

}
