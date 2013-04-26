package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.datamart.DistrictAverageDTO;

import java.util.Collection;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 22h04
 */
public interface DistrictAverageApplicationService {

    Collection<DistrictAverageDTO> findDistrictAveragesByProvince(String provinceName, Date startDate, Date endDate);

}
