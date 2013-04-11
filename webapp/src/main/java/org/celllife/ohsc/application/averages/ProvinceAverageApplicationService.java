package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.datamart.ProvinceAverageDTO;

import java.util.Collection;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 21h59
 */
public interface ProvinceAverageApplicationService {

    Collection<ProvinceAverageDTO> findProvinceAveragesByCountryName(String countryName);

}
