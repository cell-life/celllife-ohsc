package org.celllife.ohsc.integration.geotools;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opengis.feature.simple.SimpleFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-29
 * Time: 10h22
 */
@ContextConfiguration({
        "classpath:/META-INF/spring/spring-integration-geotools.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProvinceServiceIntegrationTest {

    @Autowired
    private ProvinceService provinceService;

    @Test
    public void testName() throws Exception {

        SimpleFeatureCollection simpleFeatureCollection = provinceService.findAll();
        SimpleFeatureIterator simpleFeatures = simpleFeatureCollection.features();

        while(simpleFeatures.hasNext()) {
            SimpleFeature simpleFeature = simpleFeatures.next();
            String code = (String) simpleFeature.getAttribute("CODE");
            System.out.println(code);
        }
    }
}
