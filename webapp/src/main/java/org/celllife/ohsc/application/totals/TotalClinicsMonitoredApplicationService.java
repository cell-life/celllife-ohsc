package org.celllife.ohsc.application.totals;

import java.util.Collection;

import org.celllife.ohsc.domain.datamart.TotalClinicsMonitoredDTO;

/**
 * Application service which returns the total clinics being monitored. 
 * An example of where it will be used is for the donut graphs on the homepage.
 */
public interface TotalClinicsMonitoredApplicationService {

	/**
	 * Finds the total clinics monitored by province
	 * @param countryName String name of the country, e.g. "South Africa"
	 * @return Collection of TotalClinicsMonitoredDTO, will not be null
	 */
	Collection<TotalClinicsMonitoredDTO> findClinicsMonitoredByProvince(String countryName);
}
