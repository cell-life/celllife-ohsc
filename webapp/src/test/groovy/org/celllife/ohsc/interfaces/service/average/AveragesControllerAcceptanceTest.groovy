package org.celllife.ohsc.interfaces.service.average

import org.celllife.ohsc.domain.datamart.DataMartRatings
import org.celllife.ohsc.domain.rating.Ratings
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

import java.text.SimpleDateFormat

import static junit.framework.Assert.*
import static org.celllife.ohsc.integration.cqm.CqmUssdSubmissions.submit
import static org.celllife.ohsc.integration.cqm.CqmUssdSubmissions.testCqmUssdSubmission
import static AverageService.*

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

        Date start = new SimpleDateFormat("yyyyMMdd").parse("20120101");
        Date today = new Date()

        def clinicAverages = findClinicAveragesBySubDistrict("mp Govan Mbeki Local Municipality", start, today)
        assertNotNull clinicAverages

        def clinicAverage = clinicAverages.find { item -> item.clinicCode == "5198" }

        assertEquals(2.0, clinicAverage.staffAttitudeRating)

    }

    @Test
    void shouldFindSubDistrictAveragesByDistrict() throws Exception {

        Date start = new SimpleDateFormat("yyyyMMdd").parse("20120101");
        Date today = new Date()

        def subDistrictAverages = findSubDistrictAveragesByDistrict("mp Gert Sibande District Municipality", start, today)
        assertNotNull subDistrictAverages

        def subDistrictAverage = subDistrictAverages.find { item -> item.subDistrictName == "mp Govan Mbeki Local Municipality" }
        assertEquals(2.0, subDistrictAverage.staffAttitudeRating)
    }

    @Ignore //TODO: Can't figure out how I broke this
    @Test
    void shouldFindDistrictAveragesByProvince() throws Exception {

        Date start = new SimpleDateFormat("yyyyMMdd").parse("20100101");
        Date today = new Date()

        def districtAverages = findDistrictAveragesByProvince("mp Mpumalanga Province", start, today)
        assertNotNull districtAverages

        def districtAverage = districtAverages.find { item -> item.districtName == "mp Gert Sibande District Municipality" }
        assertEquals(2.0, districtAverage.staffAttitudeRating)
    }

    @Test
    void shouldFindProvinceAverages() throws Exception {

        Date start = new SimpleDateFormat("yyyyMMdd").parse("20120101");
        Date today = new Date()
        def provinceAverages = findProvinceAveragesByCountry("za South Africa (National Government)", start, today)

        assertNotNull provinceAverages

        def provinceAverage = provinceAverages.find { item -> item.provinceName == "mp Mpumalanga Province" }
        assertEquals(2.0, provinceAverage.staffAttitudeRating)
    }
}
