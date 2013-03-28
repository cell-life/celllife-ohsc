package org.celllife.ohsc.application.average;

import org.celllife.ohsc.application.average.dto.ProvinceAverage;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-19
 * Time: 13h35
 */
public interface ProvinceAverageApplicationService {

    Set<ProvinceAverage> findProvincialAverages();

}
