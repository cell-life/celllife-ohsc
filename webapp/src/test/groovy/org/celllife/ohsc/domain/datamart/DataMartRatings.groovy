package org.celllife.ohsc.domain.datamart

import org.celllife.ohsc.framework.rest.REST
import org.joda.time.DateTime

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

    static findProvinceAveragesByCountryUrl = "${baseSearchUrl}/findProvinceAveragesByCountryName"

    static findClinicAveragesBySubDistrictName(String subDistrictName, Date startDate, Date endDate) {
        get(path: findClinicAveragesBySubDistrictNameUrl, query: [subDistrictName: subDistrictName, startDate: startDate.format("MM/dd/yy hh:mm aa"), endDate: endDate.format("MM/dd/yy hh:mm aa")])
    }

    static findSubDistrictAveragesByDistrictName(String districtName, Date startDate, Date endDate) {
        get(path: findSubDistrictAveragesByDistrictNameUrl, query: [districtName: districtName, startDate: startDate.format("MM/dd/yy hh:mm aa"), endDate: endDate.format("MM/dd/yy hh:mm aa")])
    }

    static findDistrictAveragesByProvinceName(String provinceName, Date startDate, Date endDate) {
        get(path: findDistrictAveragesByProvinceNameUrl, query: [provinceName: provinceName, startDate: startDate.format("MM/dd/yy hh:mm aa"), endDate: endDate.format("MM/dd/yy hh:mm aa")])
    }

    static findProvinceAveragesByCountryName(String countryName, Date startDate, Date endDate) {
        get(path: findProvinceAveragesByCountryUrl, query: [countryName: countryName, startDate: startDate.format("MM/dd/yy hh:mm aa"), endDate: endDate.format("MM/dd/yy hh:mm aa")])
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
