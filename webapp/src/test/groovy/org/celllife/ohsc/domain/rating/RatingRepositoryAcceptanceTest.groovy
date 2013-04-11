package org.celllife.ohsc.domain.rating

import org.celllife.ohsc.domain.datamart.DataMartRatings
import org.junit.Before
import org.junit.Test

import static junit.framework.Assert.assertEquals
import static junit.framework.Assert.assertNotNull
import static org.celllife.ohsc.integration.cqm.CqmUssdSubmissions.submit
import static org.celllife.ohsc.integration.cqm.CqmUssdSubmissions.testCqmUssdSubmission

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-11
 * Time: 16h10
 */
class RatingRepositoryAcceptanceTest {

    @Before
    void setUp() throws Exception {

        Ratings.clear()
        DataMartRatings.clear()

        submit(testCqmUssdSubmission())
    }

    @Test
    public void shouldFindByClinicCode() throws Exception {

        def ratings = Ratings.findByClinicCode("5198")

        assertNotNull ratings

        def rating = ratings.content.find { item -> item.ussdSession.id == "0" }

        def staffAttitudeRating = rating.questions.find { item -> item.domainCode == "1" }

        assertEquals(2, staffAttitudeRating.answer.value)

    }
}
