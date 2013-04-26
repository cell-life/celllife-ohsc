package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.datamart.ClinicAverageDTO;

import java.util.Collection;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 08h58
 */
public interface ClinicAverageApplicationService {

    Collection<ClinicAverageDTO> findClinicAveragesBySubDistrict(String subDistrictName, Date startDate, Date endDate);

}
