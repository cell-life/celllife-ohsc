package org.celllife.ohsc.interfaces.service.rating;


import java.util.Date;

import org.celllife.ohsc.application.rating.RatingApplicationService;
import org.celllife.ohsc.domain.datamart.ClinicIndividualRatingPageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	public ClinicIndividualRatingPageDTO findIndividualRatingsByClinic(
			@RequestParam("clinicCode") String clinicCode, 
			@RequestParam("startDate") @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") Date startDate, 
			@RequestParam("endDate") @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") Date endDate,
			@RequestParam("iDisplayStart") Integer iDisplayStart,
			@RequestParam("iDisplayLength") Integer iDisplayLength,
			@RequestParam(value="sSearch",required=false) String sSearch,
			@RequestParam(value="iSortingCols",required=false) Integer iSortingCols,
			@RequestParam(value="iSortCol_0",required=false) Integer iSortCol_0,
			@RequestParam(value="iSortCol_1",required=false) Integer iSortCol_1,
			@RequestParam(value="iSortCol_2",required=false) Integer iSortCol_2,
			@RequestParam(value="iSortCol_3",required=false) Integer iSortCol_3,
			@RequestParam(value="iSortCol_4",required=false) Integer iSortCol_4,
			@RequestParam(value="iSortCol_5",required=false) Integer iSortCol_5,
			@RequestParam(value="iSortCol_6",required=false) Integer iSortCol_6,
			@RequestParam(value="iSortCol_7",required=false) Integer iSortCol_7,
			@RequestParam(value="sSortDir_0",required=false) String sSortDir_0,
			@RequestParam(value="sSortDir_1",required=false) String sSortDir_1,
			@RequestParam(value="sSortDir_2",required=false) String sSortDir_2,
			@RequestParam(value="sSortDir_3",required=false) String sSortDir_3,
			@RequestParam(value="sSortDir_4",required=false) String sSortDir_4,
			@RequestParam(value="sSortDir_5",required=false) String sSortDir_5,
			@RequestParam(value="sSortDir_6",required=false) String sSortDir_6,
			@RequestParam(value="sSortDir_7",required=false) String sSortDir_7,
			@RequestParam(value="sEcho",required=false) String sEcho) {

		return ratingApplicationService.findIndividualRatingsByClinic(clinicCode, startDate, endDate,
				iDisplayStart, iDisplayLength, sSearch,
				iSortingCols,iSortCol_0,iSortCol_1,iSortCol_2,iSortCol_3,iSortCol_4,iSortCol_5,iSortCol_6,iSortCol_7,
				sSortDir_0,sSortDir_1,sSortDir_2,sSortDir_3,sSortDir_4,sSortDir_5,sSortDir_6,sSortDir_7,
				sEcho);
	}

}
