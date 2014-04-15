package org.celllife.ohsc.interfaces.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.access.prepost.PreAuthorize

import java.text.SimpleDateFormat

import org.celllife.ohsc.security.OhscSecurityService
import org.celllife.ohsc.framework.restclient.RESTClient

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-28
 * Time: 09h49
 */
@Controller
class ReportController {

    @Value('${averages.service.url}')
    def String averageServiceUrl;

    @Value('${rating.service.url}')
    def String ratingServiceUrl;
    
    @Autowired
    RESTClient client;
    
    @Autowired
    OhscSecurityService securityService;

    @RequestMapping("/")
    def index(Model model) {
    	if (securityService.isProvincial()) {
    		findDistrictAveragesByProvince(securityService.getProvince(), null, null, model)
    	} else {
    		findProvinceAverages("za South Africa (National Government)", null, null, model)
    	}
    }

    @RequestMapping(value="/reports/provinces", method = RequestMethod.GET)
    def findProvinceAverages(@RequestParam("country") String country, 
    	@RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") String startDate, 
    	@RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") String endDate, 
    	Model model) {

        Date sd = getStartDate(startDate)
        Date ed = getEndDate(endDate)
        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        }
        
		def averages;
        if (securityService.isProvincial()) {
            String province = securityService.getProvince()
            averages = client.get("${averageServiceUrl}/findOneProvinceAverageByCountry", [country: country, province: province, startDate: sd.format("dd/MM/yyyy hh:mm aa"), endDate: ed.format("dd/MM/yyyy hh:mm aa")])       
        } else {
            averages = client.get("${averageServiceUrl}/findProvinceAveragesByCountry", [country: country, startDate: sd.format("dd/MM/yyyy hh:mm aa"), endDate: ed.format("dd/MM/yyyy hh:mm aa")])
        }
        model.put("startDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(sd))
        model.put("endDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(ed))
        model.put("averages", averages)
        return "reports/provinces"; 
    }

    @RequestMapping(value="/reports/districts", method = RequestMethod.GET)
    def findDistrictAveragesByProvince(@RequestParam("province") String province, 
    	@RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") String startDate, 
    	@RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") String endDate, 
    	Model model) {

        Date sd = getStartDate(startDate)
        Date ed = getEndDate(endDate)
        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        }

        def averages = client.get("${averageServiceUrl}/findDistrictAveragesByProvince", [province: province, startDate: sd.format("dd/MM/yyyy hh:mm aa"), endDate: ed.format("dd/MM/yyyy hh:mm aa")])
        model.put("averages", averages)
        model.put("startDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(sd))
        model.put("endDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(ed))
        return "reports/districts";
    }

    @RequestMapping(value="/reports/subDistricts", method = RequestMethod.GET)
    def findSubDistrictAveragesByDistrict(@RequestParam("district") String districtName, 
    	@RequestParam(value="startDate", required=false) @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") String startDate, 
    	@RequestParam(value="endDate", required=false) @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") String endDate, 
    	Model model) {

        Date sd = getStartDate(startDate)
        Date ed = getEndDate(endDate)
        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        }

        def averages = client.get("${averageServiceUrl}/findSubDistrictAveragesByDistrict", [district: districtName, startDate: sd.format("dd/MM/yyyy hh:mm aa"), endDate: ed.format("dd/MM/yyyy hh:mm aa")])
        model.put("averages", averages)
        model.put("startDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(sd))
        model.put("endDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(ed))
        return "reports/subDistricts";
    }

    @RequestMapping(value="/reports/clinics", method = RequestMethod.GET)
    def findClinicAveragesBySubDistrict(@RequestParam("subDistrict") String subDistrict, 
    	@RequestParam(value="startDate", required=false) @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") String startDate, 
    	@RequestParam(value="endDate", required=false) @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") String endDate, 
    	Model model) {

        Date sd = getStartDate(startDate)
        Date ed = getEndDate(endDate)
        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        }

        def averages = client.get("${averageServiceUrl}/findClinicAveragesBySubDistrict", [subDistrict: subDistrict, startDate: sd.format("dd/MM/yyyy hh:mm aa"), endDate: ed.format("dd/MM/yyyy hh:mm aa")])
        model.put("averages", averages)
        model.put("startDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(sd))
        model.put("endDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(ed))
        return "reports/clinics";
    }

    @RequestMapping(value="/reports/ratings", method = RequestMethod.GET)
    def findRatingsByClinic(@RequestParam("clinic") String clinic, 
    	@RequestParam(value="startDate", required=false) @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") String startDate, 
    	@RequestParam(value="endDate", required=false) @DateTimeFormat(pattern="dd/MM/yyyy hh:mm aa") String endDate, 
    	Model model) {

        Date sd = getStartDate(startDate)
        Date ed = getEndDate(endDate)
        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        }
        
        def ratings = client.get("${ratingServiceUrl}/findIndividualRatingsByClinic", [
        	clinicCode: clinic, startDate: sd.format("dd/MM/yyyy hh:mm aa"), endDate: ed.format("dd/MM/yyyy hh:mm aa"),
        	iDisplayStart: 0, iDisplayLength: 1, 
        	iSortingCols: 1, iSortCol_0: 0, sSortDir_0: "asc"
        ])
        model.put("ratings", ratings)
        model.put("startDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(sd))
    	model.put("endDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(ed))
        return "reports/ratings";
    }
    
    private Date getStartDate(String startDate) {
    	Date sd
    	if (startDate.equals(null) || startDate.trim().equals("")) {
    		// set the time to the first of the month
    	    Calendar c = Calendar.getInstance()
        	c.set(Calendar.DAY_OF_MONTH, 1)
        	c.set(Calendar.HOUR, 0)
        	c.set(Calendar.MINUTE, 0)
        	c.set(Calendar.SECOND, 0)
        	c.set(Calendar.MILLISECOND, 0)
        	sd = c.getTime()
        } else {
        	sd = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(startDate)
        }
        return sd;
    }
    
    private Date getEndDate(String endDate) {
    	Date ed
        if (endDate.equals(null) || endDate.trim().equals("")) {
            // set the time to midnight today
            Calendar c = Calendar.getInstance()
            c.set(Calendar.HOUR_OF_DAY,24)
            c.set(Calendar.MINUTE,00)
            ed = c.getTime() 
        } else {
            ed = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(endDate)
        }
        return ed;
    }
}