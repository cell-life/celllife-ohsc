package org.celllife.ohsc.domain.datamart

import org.celllife.ohsc.framework.rest.REST

import static org.celllife.ohsc.framework.rest.REST.get
import static org.celllife.ohsc.framework.rest.REST.delete

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 19h34
 */
class DataMartRatings {

    static baseResourceUrl = "${REST.contextPath}/api/datamartratings"

    static baseSearchUrl = "${baseResourceUrl}/search"

    static findClinicAveragesBySubDistrictNameUrl = "${baseSearchUrl}/findClinicAveragesBySubDistrictName"

    static findSubDistrictAveragesByDistrictNameUrl = "${baseSearchUrl}/findSubDistrictAveragesByDistrictName"

    static findDistrictAveragesByProvinceNameUrl = "${baseSearchUrl}/findDistrictAveragesByProvinceName"

    static findProvinceAveragesUrl = "${baseSearchUrl}/findProvinceAverages"

    static findClinicAveragesBySubDistrictName(String subDistrictName) {
        get(path: findClinicAveragesBySubDistrictNameUrl, query: [subDistrictName: subDistrictName])
    }

    static findSubDistrictAveragesByDistrictName(String districtName) {
        get(path: findSubDistrictAveragesByDistrictNameUrl, query: [districtName: districtName])
    }

    static findDistrictAveragesByProvinceName(String provinceName) {
        get(path: findDistrictAveragesByProvinceNameUrl, query: [provinceName: provinceName])
    }

    static findProvinceAverages() {
        get(path: findProvinceAveragesUrl)
    }

    static findAll() {
        get(path: baseResourceUrl)
    }

    static clear() {

        def items = findAll().content
        items.each {
            item ->
                def linkToSelf = item.links.find { it.rel == 'self' }
                delete(path: linkToSelf.href )
        }
    }
}
