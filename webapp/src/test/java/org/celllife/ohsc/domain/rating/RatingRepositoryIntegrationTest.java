package org.celllife.ohsc.domain.rating;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 14h02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/META-INF/spring/spring-config.xml",
        "classpath:/META-INF/spring/spring-domain.xml",
        "classpath:/META-INF/spring/spring-jdbc.xml",
        "classpath:/META-INF/spring/spring-orm.xml",
        "classpath:/META-INF/spring/spring-tx.xml",
        "classpath:/META-INF/spring-data/spring-data-jpa.xml"
})
public class RatingRepositoryIntegrationTest {

    @Autowired
    private RatingRepository ratingRepository;

    @Test
    public void shouldSave() throws Exception {
        ratingRepository.findAll();
    }

    @Test
    public void shouldCalculateClinicAverages() throws Exception {
        List<Object[]> clinicAverages = ratingRepository.findClinicAverages();
        for (Object[] clinicAverage : clinicAverages) {
            for (Object o : clinicAverage) {
                System.out.println(o + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void shouldCalculateSubDistrictAverages() throws Exception {

        List<Object[]> clinicAverages = ratingRepository.findSubDistrictAverages();
        for (Object[] clinicAverage : clinicAverages) {
            for (Object o : clinicAverage) {
                System.out.println(o + "\t");
            }
            System.out.println();
        }
    }
}
