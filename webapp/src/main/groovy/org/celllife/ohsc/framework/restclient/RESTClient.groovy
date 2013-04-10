package org.celllife.ohsc.framework.restclient

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 13h23
 */
class RESTClient {

    def static get(String uri) {

        def client = new groovyx.net.http.RESTClient(uri)
        client.auth.basic("internal", "password")

        return client.get([:]).data
    }

    def static get(String uri, Map<String, Object> queryParams) {

        def client = new groovyx.net.http.RESTClient(uri)
        client.auth.basic("internal", "password")

        def args = [:]
        args.put("path", uri)
        args.put("query", queryParams)

        return client.get([:]).data
    }
}
