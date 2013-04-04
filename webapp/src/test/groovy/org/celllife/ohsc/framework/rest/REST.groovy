package org.celllife.ohsc.framework.rest

import groovyx.net.http.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 14h39
 */
class REST {

    static private RESTClient client = new RESTClient("http://localhost:9000")

    static {
        client.auth.basic("user@test.cell-life.org", "P@ssw0rd1")
    }

    static get(Map<String, ?> args) {
        return client.get(args).data
    }

    static post(Map<String, ?> args) {
        return client.post(args).data
    }
}
