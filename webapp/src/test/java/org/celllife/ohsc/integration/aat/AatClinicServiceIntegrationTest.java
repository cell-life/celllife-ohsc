package org.celllife.ohsc.integration.aat;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 14h51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/META-INF/spring/spring-config.xml",
        "classpath:/META-INF/spring/spring-integration-aat.xml"
})
public class AatClinicServiceIntegrationTest {

    @Autowired
    private AatClinicService aatClinicService;

    @Test
    public void shouldInitialize() throws Exception {

        Map<String,String> clinicShortNameToCodeMap = ((AatClinicServiceImpl) aatClinicService).clinicShortNameToCodeMap;
        Assert.assertFalse(clinicShortNameToCodeMap.isEmpty());

    }

    @Test
    public void shouldFindClinicCodeByShortName() throws Exception {

        Assert.assertEquals("0002", aatClinicService.findClinicCodeByShortName("Aberdeen Hospital"));

    }
}
