package org.celllife.ohsc.domain.datamart;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 20h30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/META-INF/spring/spring-cache.xml",
        "classpath:/META-INF/spring/spring-config.xml",
        "classpath:/META-INF/spring/spring-domain.xml",
        "classpath:/META-INF/spring/spring-integration-aat.xml",
        "classpath:/META-INF/spring/spring-jdbc.xml",
        "classpath:/META-INF/spring/spring-orm.xml",
        "classpath:/META-INF/spring/spring-tx.xml",
        "classpath:/META-INF/spring-data/spring-data-jpa.xml"
})
public class DataMartRatingRepositoryIntegrationTest {

    @Autowired
    private DataMartRatingRepository dataMartRatingRepository;
    
    private Date yesterday;

    @Before
    public void setUp() throws Exception {

        yesterday = new SimpleDateFormat("yyyyMMdd").parse(
                ""+(Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date()))-1));

        dataMartRatingRepository.deleteAll();

        DataMartRating dataMartRating = new DataMartRating();
        dataMartRating.setUssdSessionId("0");
        dataMartRating.setClinicCode("0000");
        dataMartRating.setSubDistrictName("Test Sub-District");
        dataMartRating.setDistrictName("Test District");
        dataMartRating.setProvinceName("Test Province");
        dataMartRating.setCountryName("Test Country");
        dataMartRating.setSubmissionDate(new Date());
        dataMartRating.setMsisdn("27768198075");
        dataMartRating.setSafeAndSecureCareRating(1d);
        dataMartRating.setStaffAttitudeRating(1d);
        dataMartRating.setDrugAvailabilityRating(1d);
        dataMartRating.setInfectionControlRating(1d);
        dataMartRating.setWaitingTimesRating(1d);
        dataMartRating.setCleanlinessRating(1d);

        dataMartRatingRepository.save(dataMartRating);

    }

    @Test
    public void testFindClinicAveragesBySubDistrictName() throws Exception {

        Iterable<ClinicAverageDTO> clinicAverages =
                dataMartRatingRepository.findClinicAveragesBySubDistrictName("Test Sub-District",yesterday,new Date());

        Assert.assertNotNull(clinicAverages);
        Assert.assertTrue(clinicAverages.iterator().hasNext());
    }

    @Test
    public void testFindSubDistrictAveragesByDistrictName() throws Exception {

        Iterable<SubDistrictAverageDTO> subDistrictAverages =
                dataMartRatingRepository.findSubDistrictAveragesByDistrictName("Test District",yesterday,new Date());

        Assert.assertNotNull(subDistrictAverages);
        Assert.assertTrue(subDistrictAverages.iterator().hasNext());
    }

    @Test
    public void testFindProvinceAveragesByCountryName() throws Exception {

        Iterable<ProvinceAverageDTO> provinceAverages = dataMartRatingRepository.findProvinceAveragesByCountryName("Test Country",yesterday,new Date());

        Assert.assertNotNull(provinceAverages);
        Assert.assertTrue(provinceAverages.iterator().hasNext());
    }
    
    /*@Test
    public void testFindClinicIndividualRatingsOld() throws Exception {
    	Iterable<ClinicIndividualRatingDTO> individualRatings = dataMartRatingRepository.findIndividualRatingsByClinic("0000", yesterday, new Date());
    	Assert.assertNotNull(individualRatings);
        Assert.assertTrue(individualRatings.iterator().hasNext());
    }*/
    
    @Test
    public void testFindClinicIndividualRatings() throws Exception {
    	Sort sort = new Sort(Direction.ASC, "msisdn");
    	Pageable pageable = new PageRequest(0,10, sort);
    	Page<ClinicIndividualRatingDTO> individualRatings = dataMartRatingRepository.findIndividualRatingsByClinic("0000", yesterday, new Date(), pageable);
    	Assert.assertNotNull(individualRatings);
        Assert.assertTrue(individualRatings.iterator().hasNext());
    }
}
