package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.datamart.SubDistrictAverageDTO;

import java.util.Collection;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 08h58
 */
public interface SubDistrictAverageApplicationService {

    Collection<SubDistrictAverageDTO> findSubDistrictAveragesByDistrict(String districtName);

}
