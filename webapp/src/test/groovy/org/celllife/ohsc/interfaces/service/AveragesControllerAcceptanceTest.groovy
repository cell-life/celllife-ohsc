package org.celllife.ohsc.interfaces.service

import org.celllife.ohsc.framework.rest.REST
import org.junit.Test
/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 10h17
 */
class AveragesControllerAcceptanceTest {

    @Test
    def test() throws Exception {
        println findClinicAveragesBySubDistrict("wc Cape Town Western Health sub-District")

    }

    private findClinicAveragesBySubDistrict(String subDistrictName) {
        REST.get(
                path: "/service/averages/findClinicAveragesBySubDistrict",
                query: [subDistrictName: subDistrictName]
        )
    }
}
