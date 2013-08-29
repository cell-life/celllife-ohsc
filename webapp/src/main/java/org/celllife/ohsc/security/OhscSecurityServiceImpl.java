package org.celllife.ohsc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.stereotype.Service;

/**
 * This implementation is based on a hierarchical LDAP system where users are organised as follows:
 * 
 * ou = people (OrganizationalUnit)
 *  - ou = doh (OrganizationalUnit)
 *     - ou = national (OrganizationalUnit)
 *     		- cn = <email> (inetOrgPerson)
 *     - ou = provincial (OrganizationalUnit)
 * 			- l = wc Western Cape Province (locality)
 * 				- cn = <email>  (inetOrgPerson)
 * 
 * An example of a provincial user DN for Western Cape will be:
 * cn=westerncape@cell-life.org,l=wc Western Cape Province,ou=provincial,ou=doh,ou=people,dc=cell-life,dc=org;
 * (enable DEBUG Spring logging to see this in your log files)
 *  
 * Please note 
 *  - it is not possible to setup this up using Atlassian Crowd, you need to use an LDAP application like Apache Directory Studio
 *  - you must use the DHIS province name (not short name) for the locality
 *  - users need the ROLE_OHSC (GrantedAuthority) to login to the application
 *  - since we communicate with an "internal" user between the client and the server, we will not have LDAP credentials available on the server
 *  
 *  To use in a JSP, see the following code:
 *  <pre>
 *  <sec:authorize access="@securityService.national">
 *		....
 *	</sec:authorize>
 *  </pre>
 *  
 *  To use in a method security annotation, see the following code:
 *  <pre>
 *  @PreAuthorize("@securityService.isNational()")
 *  </pre>
 */
@Service("securityService")
public class OhscSecurityServiceImpl implements OhscSecurityService {
	
	private static Logger log = LoggerFactory.getLogger(OhscSecurityServiceImpl.class);
	
	private static final String OU_NATIONAL = "ou=national";
	private static final String OU_PROVINCIAL = "ou=provincial";
	private static final String OU_DOH = "ou=doh";
	private static final String DN_DELIMITER = ",";
	private static final String DN_EQUALS = "=";
	private static final String LOCATION = "l";

	@Override
	public boolean isNational() {
		LdapUserDetails userDetails = getAuthenticatedLdapUserDetails();
		if (userDetails != null) {
			return userDetails.getDn().contains(OU_NATIONAL);
		}
		return false;
	}
	
	@Override
	public boolean isDoh() {
		LdapUserDetails userDetails = getAuthenticatedLdapUserDetails();
		if (userDetails != null) {
			return userDetails.getDn().contains(OU_DOH);
		}
		return false;	
	}

	@Override
	public boolean isProvincial() {
		LdapUserDetails userDetails = getAuthenticatedLdapUserDetails();
		if (userDetails != null) {
			return userDetails.getDn().contains(OU_PROVINCIAL);
		}
		return false;	
	}

	@Override
	public String getProvince() {
		String province = null;
		LdapUserDetails userDetails = getAuthenticatedLdapUserDetails();
		if (userDetails != null) {
			province = getLocation(userDetails.getDn());
		}
		return province;
	}
	
	private LdapUserDetails getAuthenticatedLdapUserDetails() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			Object principal = auth.getPrincipal();
			if (principal != null && principal instanceof LdapUserDetails) {
				return (LdapUserDetails)principal;
			} else if (principal == null) {
				log.warn("The logged in user does not have a principal, so cannot perform permission checks. auth="+auth);
			} else {
				log.warn("The logged in user's principal is not of type LDAP, so cannot perform permission checks. auth="+auth);
			}
		}
		return null;
	}
	
	String getLocation(String dn) {
		if (dn != null) {
			String[] dnParts = dn.split(DN_DELIMITER);
			for (String part : dnParts) {
				String[] expression = part.split(DN_EQUALS);
				if (expression[0].equals(LOCATION)) {
					return expression[1];
				}
			}
		}
		return null;
	}
}
