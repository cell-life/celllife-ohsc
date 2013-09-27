package org.celllife.ohsc.interfaces.service.average

import org.celllife.ohsc.framework.rest.REST
import org.springframework.web.bind.annotation.RequestParam

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 19h36
 */
class AverageService {

    static baseAveragesUrl = "${REST.contextPath}/service/averages"

    static findClinicAveragesBySubDistrict(String subDistrict, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        REST.get(
                path: "${baseAveragesUrl}/findClinicAveragesBySubDistrict",
                query: [subDistrict: subDistrict, startDate: startDate.format("dd/MM/yyyy hh:mm aa"), endDate: endDate.format("dd/MM/yyyy hh:mm aa")]
        )
    }

    static findSubDistrictAveragesByDistrict(String district, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        REST.get(
                path: "${baseAveragesUrl}/findSubDistrictAveragesByDistrict",
                query: [district: district, startDate: startDate.format("dd/MM/yyyy hh:mm aa"), endDate: endDate.format("dd/MM/yyyy hh:mm aa")]
        )
    }

    static findDistrictAveragesByProvince(String province, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        REST.get(
                path: "${baseAveragesUrl}/findDistrictAveragesByProvince",
                query: [province: province, startDate: startDate.format("dd/MM/yyyy hh:mm aa"), endDate: endDate.format("dd/MM/yyyy hh:mm aa")]
        )
    }

    static findProvinceAveragesByCountry(String country, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        REST.get(
                path: "${baseAveragesUrl}/findProvinceAveragesByCountry",
                query: [country: country, startDate: startDate.format("dd/MM/yyyy hh:mm aa"), endDate: endDate.format("dd/MM/yyyy hh:mm aa")]
        )
    }
}
