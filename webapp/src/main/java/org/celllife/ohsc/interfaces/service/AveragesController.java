package org.celllife.ohsc.interfaces.service;

import org.celllife.ohsc.application.averages.AveragesApplicationService;
import org.celllife.ohsc.domain.datamart.ClinicAverage;
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
    private AveragesApplicationService averagesApplicationService;

    @ResponseBody
    @RequestMapping(
            value = "/service/averages/findClinicAveragesBySubDistrict",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<ClinicAverage> findClinicAveragesBySubDistrict(@RequestParam("subDistrictName") String subDistrictName) {

        return averagesApplicationService.findClinicAveragesBySubDistrict(subDistrictName);
    }

}
