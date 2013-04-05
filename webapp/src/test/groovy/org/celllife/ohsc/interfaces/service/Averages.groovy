package org.celllife.ohsc.interfaces.service

import org.celllife.ohsc.framework.rest.REST

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 19h36
 */
class Averages {

    static findClinicAveragesBySubDistrict(String subDistrictName) {
        REST.get(
                path: "/service/averages/findClinicAveragesBySubDistrict",
                query: [subDistrictName: subDistrictName]
        )
    }

    static findSubDistrictAveragesByDistrict(String districtName) {
        REST.get(
                path: "/service/averages/findSubDistrictAveragesByDistrict",
                query: [districtName: districtName]
        )
    }

    static findDistrictAveragesByProvince(String provinceName) {
        REST.get(
                path: "/service/averages/findDistrictAveragesByProvince",
                query: [provinceName: provinceName]
        )
    }

    static findProvinceAverages() {
        REST.get(path: "/service/averages/findProvinceAverages")
    }
}
