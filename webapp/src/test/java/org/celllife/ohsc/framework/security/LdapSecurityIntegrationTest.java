package org.celllife.ohsc.framework.security;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-28
 * Time: 15h07
 */
@ContextConfiguration({
        "classpath:/META-INF/spring/spring-config.xml",
        "classpath:/META-INF/spring-security/spring-security-cas.xml",
        "classpath:/META-INF/spring-security/spring-security-core.xml",
        "classpath:/META-INF/spring-security/spring-security-ldap.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class LdapSecurityIntegrationTest {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Test
    public void testName() throws Exception {

        Authentication authentication = new UsernamePasswordAuthenticationToken("internal", "password");
        authentication = authenticationManager.authenticate(authentication);

        Assert.assertNotNull(authentication);

    }
}
