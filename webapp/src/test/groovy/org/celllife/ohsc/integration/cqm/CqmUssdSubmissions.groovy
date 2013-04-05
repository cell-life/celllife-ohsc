package org.celllife.ohsc.integration.cqm

import groovyx.net.http.ContentType
import org.celllife.ohsc.framework.json.JSON

import static org.celllife.ohsc.framework.rest.REST.post

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 19h29
 */
class CqmUssdSubmissions {

    static String baseLocation = "/data/CqmUssdSubmissionRequest"

    static submit(Object cqm) {
        post(
                path: "/service/cqmUssdSubmission",
                body: cqm,
                requestContentType: ContentType.JSON
        )
    }

    static testCqmUssdSubmission(String id = "0000") {
        JSON.readFromClasspath("${baseLocation}/${id}.json")
    }

}
