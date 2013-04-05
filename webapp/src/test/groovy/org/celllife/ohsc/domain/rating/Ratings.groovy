package org.celllife.ohsc.domain.rating

import static org.celllife.ohsc.framework.rest.REST.delete
import static org.celllife.ohsc.framework.rest.REST.get

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 19h43
 */
class Ratings {

    static String baseResourceUrl = "/api/ratings"

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