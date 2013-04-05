package org.celllife.ohsc.interfaces.service;

import org.celllife.ohsc.application.averages.ClinicAverageApplicationService;
import org.celllife.ohsc.application.averages.DistrictAverageApplicationService;
import org.celllife.ohsc.application.averages.ProvinceAverageApplicationService;
import org.celllife.ohsc.application.averages.SubDistrictAverageApplicationService;
import org.celllife.ohsc.domain.datamart.ClinicAverage;
import org.celllife.ohsc.domain.datamart.DistrictAverage;
import org.celllife.ohsc.domain.datamart.ProvinceAverage;
import org.celllife.ohsc.domain.datamart.SubDistrictAverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 10h17
 */
@Controller
public class AveragesController {

    @Autowired
    private ClinicAverageApplicationService clinicAverageApplicationService;

    @Autowired
    private SubDistrictAverageApplicationService subDistrictAverageApplicationService;

    @Autowired
    private DistrictAverageApplicationService districtAverageApplicationService;

    @Autowired
    private ProvinceAverageApplicationService provinceAverageApplicationService;

    @ResponseBody
    @RequestMapping(
            value = "/service/averages/findClinicAveragesBySubDistrict",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<ClinicAverage> findClinicAveragesBySubDistrict(@RequestParam("subDistrictName")
                                                                         String subDistrictName) {

        return clinicAverageApplicationService.findClinicAveragesBySubDistrict(subDistrictName);
    }

    @ResponseBody
    @RequestMapping(
            value = "/service/averages/findSubDistrictAveragesByDistrict",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<SubDistrictAverage> findSubDistrictAveragesBySubDistrict(@RequestParam("districtName")
                                                                                   String districtName) {

        return subDistrictAverageApplicationService.findSubDistrictAveragesByDistrict(districtName);
    }

    @ResponseBody
    @RequestMapping(
            value = "/service/averages/findDistrictAveragesByProvince",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<DistrictAverage> findDistrictAveragesByProvince(@RequestParam("provinceName")
                                                                                   String provinceName) {

        return districtAverageApplicationService.findDistrictAveragesByProvince(provinceName);
    }

    @ResponseBody
    @RequestMapping(
            value = "/service/averages/findProvinceAverages",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<ProvinceAverage> findProvinceAverages() {

        return provinceAverageApplicationService.findProvinceAverages();
    }

}
