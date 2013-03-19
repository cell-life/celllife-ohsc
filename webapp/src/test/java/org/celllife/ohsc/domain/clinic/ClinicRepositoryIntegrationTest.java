package org.celllife.ohsc.domain.clinic;

import org.celllife.ohsc.integration.aat.AatClinicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 21h45
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
public class ClinicRepositoryIntegrationTest {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private AatClinicService aatClinicService;

    @Test
    public void testFindOneByCode() throws Exception {

    }
}
