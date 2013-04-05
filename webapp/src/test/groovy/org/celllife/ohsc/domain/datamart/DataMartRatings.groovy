package org.celllife.ohsc.domain.datamart

import static org.celllife.ohsc.framework.rest.REST.delete
import static org.celllife.ohsc.framework.rest.REST.get

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 19h34
 */
class DataMartRatings {

    static baseResourceUrl = "/api/datamartratings"

    static baseSearchUrl = "${baseResourceUrl}/search"

    static findClinicAveragesBySubDistrictNameUrl = "${baseSearchUrl}/findClinicAveragesBySubDistrictName"

    static findSubDistrictAveragesByDistrictNameUrl = "${baseSearchUrl}/findSubDistrictAveragesByDistrictName"

    static findClinicAveragesBySubDistrictName(String subDistrictName) {
        get(path: findClinicAveragesBySubDistrictNameUrl, query: [subDistrictName: subDistrictName])
    }

    static findSubDistrictAveragesByDistrictName(String districtName) {
        get(path: findSubDistrictAveragesByDistrictNameUrl, query: [subDistrictName: districtName])
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
