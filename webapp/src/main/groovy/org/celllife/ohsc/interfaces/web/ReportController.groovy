package org.celllife.ohsc.interfaces.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.access.prepost.PreAuthorize

import java.text.SimpleDateFormat

import org.celllife.ohsc.security.OhscSecurityService

import static org.celllife.ohsc.framework.restclient.RESTClient.get
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
    def findProvinceAverages(@RequestParam("country") String country, @RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate, Model model) {

        Date sd
        if (startDate.equals(null) || startDate.trim().equals(""))
            sd = new Date(946684800) //This is Unix time for 01 Jan 2000
        else
            sd = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(startDate)

        Date ed

        if (endDate.equals(null) || endDate.trim().equals(""))
            ed = new Date()
        else
            ed = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(endDate)

		def averages;
        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        } else if (securityService.isProvincial()) {
            String province = securityService.getProvince()
            averages = get("${averageServiceUrl}/findOneProvinceAverageByCountry", [country: country, province: province, startDate: sd.format("MM/dd/yy hh:mm aa"), endDate: ed.format("MM/dd/yy hh:mm aa")])       
        } else {
            averages = get("${averageServiceUrl}/findProvinceAveragesByCountry", [country: country, startDate: sd.format("MM/dd/yy hh:mm aa"), endDate: ed.format("MM/dd/yy hh:mm aa")])
        }
        model.put("startDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(sd))
        model.put("endDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(ed))
        model.put("averages", averages)
        return "reports/provinces"; 
    }

    @RequestMapping(value="/reports/districts", method = RequestMethod.GET)
    def findDistrictAveragesByProvince(@RequestParam("province") String province, @RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate, Model model) {

        Date sd
        if (startDate.equals(null) || startDate.trim().equals(""))
            sd = new Date(946684800) //This is Unix time for 01 Jan 2000
        else
            sd = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(startDate)

        Date ed

        if (endDate.equals(null) || endDate.trim().equals(""))
            ed = new Date()
        else
            ed = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(endDate)

        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        }

        def averages = get("${averageServiceUrl}/findDistrictAveragesByProvince", [province: province, startDate: sd.format("MM/dd/yy hh:mm aa"), endDate: ed.format("MM/dd/yy hh:mm aa")])
        model.put("averages", averages)
        model.put("startDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(sd))
        model.put("endDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(ed))
        return "reports/districts";
    }

    @RequestMapping(value="/reports/subDistricts", method = RequestMethod.GET)
    def findSubDistrictAveragesByDistrict(@RequestParam("district") String districtName, @RequestParam(value="startDate", required=false) String startDate, @RequestParam(value="endDate", required=false) String endDate, Model model) {

        Date sd
        if (startDate.equals(null) || startDate.trim().equals(""))
            sd = new Date(946684800) //This is Unix time for 01 Jan 2000
        else
            sd = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(startDate)

        Date ed
        if (endDate.equals(null) || endDate.trim().equals(""))
            ed = new Date()
        else
            ed = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(endDate)

        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        }
        def averages = get("${averageServiceUrl}/findSubDistrictAveragesByDistrict", [district: districtName, startDate: sd.format("MM/dd/yy hh:mm aa"), endDate: ed.format("MM/dd/yy hh:mm aa")])
        model.put("averages", averages)
        model.put("startDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(sd))
        model.put("endDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(ed))
        return "reports/subDistricts";
    }

    @RequestMapping(value="/reports/clinics", method = RequestMethod.GET)
    def findClinicAveragesBySubDistrict(@RequestParam("subDistrict") String subDistrict, @RequestParam(value="startDate", required=false) String startDate, @RequestParam(value="endDate", required=false) String endDate, Model model) {

        Date sd
        if (startDate.equals(null) || startDate.trim().equals(""))
            sd = new Date(946684800) //This is Unix time for 01 Jan 2000
        else
            sd = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(startDate)

        Date ed
        if (endDate.equals(null) || endDate.trim().equals(""))
            ed = new Date()
        else
            ed = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(endDate)

        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        }
        def averages = get("${averageServiceUrl}/findClinicAveragesBySubDistrict", [subDistrict: subDistrict, startDate: sd.format("MM/dd/yy hh:mm aa"), endDate: ed.format("MM/dd/yy hh:mm aa")])
        model.put("averages", averages)
        model.put("startDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(sd))
        model.put("endDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(ed))
        return "reports/clinics";
    }

    @RequestMapping(value="/reports/ratings", method = RequestMethod.GET)
    def findRatingsByClinic(@RequestParam("clinic") String clinic, @RequestParam(value="startDate", required=false) String startDate, @RequestParam(value="endDate", required=false) String endDate, Model model) {

        Date sd
        if (startDate.equals(null) || startDate.trim().equals(""))
            sd = new Date(946684800) //This is Unix time for 01 Jan 2000
        else
            sd = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(startDate)

        Date ed
        if (endDate.equals(null) || endDate.trim().equals(""))
            ed = new Date()
        else
            ed = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(endDate)

        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        }
        
        def ratings = get("${ratingServiceUrl}/findIndividualRatingsByClinic", [
        	clinicCode: clinic, startDate: sd.format("MM/dd/yy hh:mm aa"), endDate: ed.format("MM/dd/yy hh:mm aa"),
        	iDisplayStart: 0, iDisplayLength: 1, 
        	iSortingCols: 1, iSortCol_0: 0, sSortDir_0: "asc"
        ])
        model.put("ratings", ratings)
        model.put("startDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(sd))
    	model.put("endDate",new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(ed))
        return "reports/ratings";
    }
}