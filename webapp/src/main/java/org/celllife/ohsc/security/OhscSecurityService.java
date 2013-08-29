package org.celllife.ohsc.security;


/**
 * Service to implement the security for the OHSC web application.
 * At the moment the security is based around two roles
 *  a) national: user who can see all (country-wide) data
 *  b) provincial: user who can only see their own province's data
 *  
 * Please see the implementation class for more details on the LDAP implementation
 *
 * Note: OHSC role is also required to log into the application
 */
public interface OhscSecurityService {

	/**
	 * Determines if the logged in user is a national user
	 * @return boolean
	 */
	boolean isNational();
	
	/**
	 * Determines if the logged in user is a DOH user
	 * @return boolean
	 */
	boolean isDoh();

	/**
	 * Determines if the logged in user if a provincial user
	 * @return boolean
	 */
	boolean isProvincial();

	/**
	 * Determines which province the provincial user is assigned to
	 * @return String, null if no province assigned (or user is not a provincial user)
	 */
	String getProvince();
}
