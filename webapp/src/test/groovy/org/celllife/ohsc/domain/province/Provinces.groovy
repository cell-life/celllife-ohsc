package org.celllife.ohsc.domain.province

import org.celllife.ohsc.framework.rest.REST

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 22h12
 */
class Provinces {

    static baseResourceUrl = "/api/provinces"

    static baseSearchUrl = "${baseResourceUrl}/search"

    static findAll() {
        REST.get(path: baseResourceUrl)
    }
    static findAllProvinceNames() {
        REST.get(path: "${baseSearchUrl}/findAllProvinceNames")
    }
}
