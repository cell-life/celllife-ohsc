package org.celllife.ohsc.interfaces.service.total;

import java.util.Collection;

import org.celllife.ohsc.application.totals.TotalClinicsMonitoredApplicationService;
import org.celllife.ohsc.domain.datamart.TotalClinicsMonitoredDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Web Controller for displaying clinic totals such as the number of clinics
 * with ratings vs the total number of clinics.
 */
@Controller
public class TotalsController {

	@Autowired
	private TotalClinicsMonitoredApplicationService totalClinicsMonitoredApplicationService;

	@ResponseBody
	@RequestMapping(value = "/service/totals/findClinicsMonitoredByProvince", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<TotalClinicsMonitoredDTO> findClinicAveragesBySubDistrict(
			@RequestParam("country") String country) {

		return totalClinicsMonitoredApplicationService.findClinicsMonitoredByProvince(country);
	}

}
