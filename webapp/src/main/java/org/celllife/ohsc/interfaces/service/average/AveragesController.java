package org.celllife.ohsc.interfaces.service.average;

import java.util.Collection;
import java.util.Date;

import org.celllife.ohsc.application.averages.ClinicAverageApplicationService;
import org.celllife.ohsc.application.averages.DistrictAverageApplicationService;
import org.celllife.ohsc.application.averages.ProvinceAverageApplicationService;
import org.celllife.ohsc.application.averages.SubDistrictAverageApplicationService;
import org.celllife.ohsc.domain.datamart.ClinicAverageDTO;
import org.celllife.ohsc.domain.datamart.DistrictAverageDTO;
import org.celllife.ohsc.domain.datamart.ProvinceAverageDTO;
import org.celllife.ohsc.domain.datamart.SubDistrictAverageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Collection<ClinicAverageDTO> findClinicAveragesBySubDistrict(@RequestParam("subDistrict")
                                                                        String subDistrict, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {

        return clinicAverageApplicationService.findClinicAveragesBySubDistrict(subDistrict, startDate, endDate);
    }

    @ResponseBody
    @RequestMapping(
            value = "/service/averages/findSubDistrictAveragesByDistrict",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<SubDistrictAverageDTO> findSubDistrictAveragesBySubDistrict(@RequestParam("district")
                                                                                  String district, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {

        return subDistrictAverageApplicationService.findSubDistrictAveragesByDistrict(district, startDate, endDate);
    }

    @ResponseBody
    @RequestMapping(
            value = "/service/averages/findDistrictAveragesByProvince",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<DistrictAverageDTO> findDistrictAveragesByProvince(@RequestParam("province") String province, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {

        return districtAverageApplicationService.findDistrictAveragesByProvince(province, startDate, endDate);
    }

    @ResponseBody
    @RequestMapping(
            value = "/service/averages/findProvinceAveragesByCountry",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<ProvinceAverageDTO> findProvinceAveragesByCountry(@RequestParam("country") String country, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {

        return provinceAverageApplicationService.findProvinceAveragesByCountryName(country, startDate, endDate);
    }
    
    @ResponseBody
    @RequestMapping(
            value = "/service/averages/findOneProvinceAverageByCountry",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<ProvinceAverageDTO> findOneProvinceAverageByCountry(@RequestParam("country") String country, @RequestParam("province") String province, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {

        return provinceAverageApplicationService.findOneProvinceAverageByCountryName(country, province, startDate, endDate);
    }

}