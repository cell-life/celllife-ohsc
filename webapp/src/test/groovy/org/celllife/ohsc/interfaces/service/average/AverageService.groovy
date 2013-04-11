package org.celllife.ohsc.interfaces.service.average

import org.celllife.ohsc.framework.rest.REST

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 19h36
 */
class AverageService {

    static baseAveragesUrl = "${REST.contextPath}/service/averages"

    static findClinicAveragesBySubDistrict(String subDistrict) {
        REST.get(
                path: "${baseAveragesUrl}/findClinicAveragesBySubDistrict",
                query: [subDistrict: subDistrict]
        )
    }

    static findSubDistrictAveragesByDistrict(String district) {
        REST.get(
                path: "${baseAveragesUrl}/findSubDistrictAveragesByDistrict",
                query: [district: district]
        )
    }

    static findDistrictAveragesByProvince(String province) {
        REST.get(
                path: "${baseAveragesUrl}/findDistrictAveragesByProvince",
                query: [province: province]
        )
    }

    static findProvinceAveragesByCountry(String country) {
        REST.get(
                path: "${baseAveragesUrl}/findProvinceAveragesByCountry",
                query: [country: country]
        )
    }
}
