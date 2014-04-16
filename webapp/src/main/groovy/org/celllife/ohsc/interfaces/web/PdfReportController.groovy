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

@Controller
class PdfReportController {

    @Value('${external.base.url}')
    def String externalBaseUrl;
   
    @Autowired
    OhscSecurityService securityService
    
    @Autowired
    RESTClient client;

    @RequestMapping("/pdfReports")
    def index(Model model) {
        getReports(model)
    }

    @RequestMapping(value="/reports/pdfReports", method = RequestMethod.GET)
    def getReports(Model model) {

        def reports = client.get("${externalBaseUrl}/service/reports")
        model.put("reports", reports)
        return "reports/pdfReports";

    }

}
