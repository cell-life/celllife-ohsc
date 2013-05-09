package org.celllife.ohsc.interfaces.service.rating;


import java.util.Date;

import org.celllife.ohsc.application.rating.RatingApplicationService;
import org.celllife.ohsc.domain.datamart.ClinicIndividualRatingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Web Controller for retrieving the ratings for a clinic
 */
@Controller
public class RatingsController {

	@Autowired
	private RatingApplicationService ratingApplicationService;

	@ResponseBody
	@RequestMapping(value = "/service/ratings/findIndividualRatingsByClinic", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<ClinicIndividualRatingDTO> findIndividualRatingsByClinic(
			@RequestParam("clinicCode") String clinicCode, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {

		return ratingApplicationService.findIndividualRatingsByClinic(clinicCode, startDate, endDate);
	}

}
