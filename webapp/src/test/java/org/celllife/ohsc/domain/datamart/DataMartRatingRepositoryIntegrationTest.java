package org.celllife.ohsc.domain.datamart;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Before
    public void setUp() throws Exception {

        dataMartRatingRepository.deleteAll();

        DataMartRating dataMartRating = new DataMartRating();
        dataMartRating.setUssdSessionId("0");
        dataMartRating.setClinicCode("0000");
        dataMartRating.setSubDistrictName("Test Sub-District");
        dataMartRating.setDistrictName("Test District");
        dataMartRating.setProvinceName("Test Province");

        dataMartRatingRepository.save(dataMartRating);

    }

    @Test
    public void testFindClinicAveragesBySubDistrictName() throws Exception {

        Iterable<ClinicAverageDTO> clinicAverages =
                dataMartRatingRepository.findClinicAveragesBySubDistrictName("Test Sub-District");

        Assert.assertNotNull(clinicAverages);
        Assert.assertTrue(clinicAverages.iterator().hasNext());
    }

    @Test
    public void testFindSubDistrictAveragesByDistrictName() throws Exception {

        Iterable<SubDistrictAverageDTO> subDistrictAverages =
                dataMartRatingRepository.findSubDistrictAveragesByDistrictName("Test District");

        Assert.assertNotNull(subDistrictAverages);
        Assert.assertTrue(subDistrictAverages.iterator().hasNext());
    }
}
