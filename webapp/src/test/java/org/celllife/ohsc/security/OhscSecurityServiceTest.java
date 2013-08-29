package org.celllife.ohsc.security;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/META-INF/spring/spring-security.xml" })
public class OhscSecurityServiceTest {

	@Autowired
	OhscSecurityService securityService;

	@Test
	public void testDoesntFailWithNoAuth() throws Exception {
		Assert.assertNull(securityService.getProvince());
	}

	@Test
	public void testGetLocation() throws Exception {
		OhscSecurityServiceImpl serviceImpl = new OhscSecurityServiceImpl();
		String location = serviceImpl
				.getLocation("cn=westerncape@cell-life.org,l=wc Western Cape Province,ou=provincial,ou=doh,ou=people,dc=cell-life,dc=org;");
		Assert.assertEquals("wc Western Cape Province",location);
	}
}
