package org.celllife.ohsc.framework.restclient

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 13h23
 */
class RESTClient {

    def static get(String uri) {
        return new groovyx.net.http.RESTClient(uri).get([:]).data
    }
}
