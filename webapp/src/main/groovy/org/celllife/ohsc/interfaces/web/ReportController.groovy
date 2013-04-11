package org.celllife.ohsc.interfaces.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import static org.celllife.ohsc.framework.restclient.RESTClient.get
/**
 * User: Kevin W. Sewell
 * Date: 2013-03-28
 * Time: 09h49
 */
@Controller
class ReportController {

    @Value('${averages.service.url}')
    def String averageServiceUrl;

    @Value('${rating.service.url}')
    def String ratingServiceUrl;

    @RequestMapping(value="/reports/provinces", method = RequestMethod.GET)
    def findProvinceAverages(@RequestParam("country") String country, Model model) {

        def averages = get("${averageServiceUrl}/findProvinceAveragesByCountry", [country: country])

        model.put("averages", averages)

        return "reports/provinces";
    }

    @RequestMapping(value="/reports/districts", method = RequestMethod.GET)
    def findDistrictAveragesByProvince(@RequestParam("province") String province, Model model) {

        def averages = get("${averageServiceUrl}/findDistrictAveragesByProvince", [province: province])

        model.put("averages", averages)

        return "reports/districts";
    }

    @RequestMapping(value="/reports/subDistricts", method = RequestMethod.GET)
    def findSubDistrictAveragesByDistrict(@RequestParam("district") String districtName, Model model) {

        def averages = get("${averageServiceUrl}/findSubDistrictAveragesByDistrict", [district: districtName])

        model.put("averages", averages)

        return "reports/subDistricts";
    }

    @RequestMapping(value="/reports/clinics", method = RequestMethod.GET)
    def findClinicAveragesBySubDistrict(@RequestParam("subDistrict") String subDistrict, Model model) {

        def averages = get("${averageServiceUrl}/findClinicAveragesBySubDistrict", [subDistrict: subDistrict])

        model.put("averages", averages)

        return "reports/clinics";
    }

    @RequestMapping(value="/reports/ratings", method = RequestMethod.GET)
    def findRatingsByClinic(@RequestParam("clinic") String clinic, Model model) {

        def averages = get("${ratingServiceUrl}/findClinicAveragesBySubDistrict", [clinic: clinic])

        model.put("averages", averages)

        return "reports/clinics";
    }
}
