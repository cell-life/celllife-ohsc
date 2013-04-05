package org.celllife.ohsc.interfaces.service

import org.celllife.ohsc.domain.datamart.DataMartRatings
import org.celllife.ohsc.domain.rating.Ratings
import org.junit.Before
import org.junit.Test

import static junit.framework.Assert.*
import static org.celllife.ohsc.integration.cqm.CqmUssdSubmissions.submit
import static org.celllife.ohsc.integration.cqm.CqmUssdSubmissions.testCqmUssdSubmission
import static org.celllife.ohsc.interfaces.service.Averages.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 10h17
 */
class AveragesControllerAcceptanceTest {

    @Before
    void setup() throws Exception {

        Ratings.clear()
        DataMartRatings.clear()

        submit(testCqmUssdSubmission())
    }

    @Test
    void shouldFindClinicAveragesBySubDistrict() throws Exception {

        def clinicAverages = findClinicAveragesBySubDistrict("mp Govan Mbeki Local Municipality")

        assertNotNull clinicAverages

        def clinicAverage = clinicAverages.find { it.clinicCode == "5198" }
        assertEquals(2.0, clinicAverage.staffAttitudeAverage)

    }

    @Test
    void shouldFindSubDistrictAveragesByDistrict() throws Exception {

        def subDistrictAverages = findSubDistrictAveragesByDistrict("mp Gert Sibande District Municipality")

        assertNotNull subDistrictAverages

        def subDistrictAverage = subDistrictAverages.find { it.subDistrictName == "mp Govan Mbeki Local Municipality" }
        assertEquals(2.0, subDistrictAverage.staffAttitudeAverage)
    }

    @Test
    void shouldFindDistrictAveragesByProvince() throws Exception {

        def districtAverages = findDistrictAveragesByProvince("mp Mpumalanga Province")

        assertNotNull districtAverages

        def districtAverage = districtAverages.find { it.districtName == "mp Gert Sibande District Municipality" }
        assertEquals(2.0, districtAverage.staffAttitudeAverage)
    }

    @Test
    void shouldFindProvinceAverages() throws Exception {

        def provinceAverages = findProvinceAverages()

        assertNotNull provinceAverages

        def provinceAverage = provinceAverages.find { it.provinceName == "mp Mpumalanga Province" }
        assertEquals(2.0, provinceAverage.staffAttitudeAverage)
    }
}
