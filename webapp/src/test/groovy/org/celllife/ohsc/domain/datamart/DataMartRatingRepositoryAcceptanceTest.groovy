package org.celllife.ohsc.domain.datamart

import groovy.json.JsonSlurper
import groovyx.net.http.ContentType
import junit.framework.Assert
import org.celllife.ohsc.framework.rest.REST
import org.junit.Test
/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 14h33
 */
class DataMartRatingRepositoryAcceptanceTest {

    @Test
    public void testName() throws Exception {

        def inputStream = getClass().getResourceAsStream("/data/CqmUssdSubmissionRequest_load/0000.json")

        Assert.assertNotNull(inputStream)

        def cqm = new JsonSlurper().parse(new InputStreamReader(inputStream))

        submit(cqm)

        println findAllClinicAveragesBySubDistrictName("mp Govan Mbeki Local Municipality")
    }

    def findAllClinicAveragesBySubDistrictName(String subDistrictName) {
        REST.get(
                path: "/api/datamartratings/search/findAllClinicAveragesBySubDistrictName",
                query: [subDistrictName: subDistrictName]
        )
    }

    def submit(Object cqm) {
        REST.post(
                path: "/services/cqmUssdSubmission",
                body: cqm,
                requestContentType: ContentType.JSON
        )
    }
}
