package org.celllife.ohsc.integration.geotools;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opengis.feature.simple.SimpleFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.celllife.ohsc.integration.geotools.Districts.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-29
 * Time: 10h42
 */
@ContextConfiguration({
        "classpath:/META-INF/spring/spring-integration-geotools.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class DistrictServiceIntegrationTest {

    @Autowired
    private DistrictService districtService;

    @Test
    public void testFindAll() throws Exception {

        SimpleFeatureCollection localities = districtService.findAll();
        SimpleFeatureIterator simpleFeatures = localities.features();

        while(simpleFeatures.hasNext()) {
            SimpleFeature simpleFeature = simpleFeatures.next();
            System.out.println(getCode(simpleFeature) + "\t:\t" + getName(simpleFeature) );
        }
    }

    @Test
    public void testFindByCode() throws Exception {

    }

    @Test
    public void testFindByName() throws Exception {

        SimpleFeatureCollection localities = districtService.findByNameLike("J");
        SimpleFeatureIterator simpleFeatures = localities.features();

        while(simpleFeatures.hasNext()) {
            SimpleFeature simpleFeature = simpleFeatures.next();
            System.out.println(simpleFeature.getAttribute("MUNICNAME"));
        }
    }

    @Test
    public void testFindByDistrict() throws Exception {

    }

    @Test
    public void testFindByProvince() throws Exception {

    }
}
