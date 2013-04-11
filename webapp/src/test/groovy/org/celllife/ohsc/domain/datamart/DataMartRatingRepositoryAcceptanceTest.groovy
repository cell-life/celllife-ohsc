package org.celllife.ohsc.domain.datamart

import org.celllife.ohsc.domain.rating.Ratings
import org.junit.Before
import org.junit.Test

import static junit.framework.Assert.assertEquals
import static junit.framework.Assert.assertNotNull
import static org.celllife.ohsc.domain.datamart.DataMartRatings.*
import static org.celllife.ohsc.integration.cqm.CqmUssdSubmissions.testCqmUssdSubmission
import static org.celllife.ohsc.integration.cqm.CqmUssdSubmissions.submit

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 14h33
 */
class DataMartRatingRepositoryAcceptanceTest {

    @Before
    void setUp() throws Exception {

        Ratings.clear()
        DataMartRatings.clear()

        submit(testCqmUssdSubmission())
    }

    @Test
    void shouldFindAll() throws Exception {

        def dataMartRatings = DataMartRatings.findAll()

        assertNotNull dataMartRatings

        def dataMartRating = dataMartRatings.content.find { item -> item.subDistrictName == "mp Govan Mbeki Local Municipality" }
        assertEquals(2.0, dataMartRating.staffAttitudeRating)
    }

    @Test
    void shouldFindClinicAveragesBySubDistrictName() throws Exception {

        def clinicAverages = findClinicAveragesBySubDistrictName("mp Govan Mbeki Local Municipality")

        assertNotNull clinicAverages

        def clinicAverage = clinicAverages.content.find { item -> item.clinicCode == "5198" }
        assertEquals(2.0, clinicAverage.staffAttitudeRating)
    }

    @Test
    void shouldFindSubDistrictAveragesByDistrictName() throws Exception {

        def subDistrictAverages = findSubDistrictAveragesByDistrictName("mp Gert Sibande District Municipality")

        assertNotNull subDistrictAverages

        def subDistrictAverage = subDistrictAverages.content.find { item -> item.subDistrictName == "mp Govan Mbeki Local Municipality" }
        assertEquals(2.0, subDistrictAverage.staffAttitudeRating)
    }

    @Test
    void shouldFindDistrictAveragesByProvinceName() throws Exception {

        def districtAverages = findDistrictAveragesByProvinceName("mp Mpumalanga Province")

        assertNotNull districtAverages

        def districtAverage = districtAverages.content.find { item -> item.districtName == "mp Gert Sibande District Municipality" }
        assertEquals(2.0, districtAverage.staffAttitudeRating)
    }

    @Test
    void shouldFindProvinceAverages() throws Exception {

        def provinceAverages = findProvinceAveragesByCountryName("za South Africa (National Government)")

        assertNotNull provinceAverages

        def provinceAverage = provinceAverages.content.find { item -> item.provinceName == "mp Mpumalanga Province" }
        assertEquals(2.0, provinceAverage.staffAttitudeRating)
    }
}
