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

        def dataMartRating = dataMartRatings.content.find { it.subDistrictName == "mp Govan Mbeki Local Municipality" }
        assertEquals(2.0, dataMartRating.staffAttitudeRating)
    }

    @Test
    void shouldFindClinicAveragesBySubDistrictName() throws Exception {

        def clinicAverages = findClinicAveragesBySubDistrictName("mp Govan Mbeki Local Municipality")

        assertNotNull clinicAverages

        def clinicAverage = clinicAverages.content.find { it.clinicCode == "5198" }
        assertEquals(2.0, clinicAverage.staffAttitudeAverage)
    }

    @Test
    void shouldFindSubDistrictAveragesByDistrictName() throws Exception {

        def subDistrictAverages = findSubDistrictAveragesByDistrictName("mp Gert Sibande District Municipality")

        assertNotNull subDistrictAverages

        def subDistrictAverage = subDistrictAverages.content.find { it.subDistrictName == "mp Govan Mbeki Local Municipality" }
        assertEquals(2.0, subDistrictAverage.staffAttitudeAverage)
    }
}
