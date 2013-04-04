package org.celllife.ohsc.interfaces.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
/**
 * User: Kevin W. Sewell
 * Date: 2013-03-28
 * Time: 09h49
 */
@Controller
@RequestMapping("/test")
class NewReportController {

	@RequestMapping(method = RequestMethod.GET)
	def index(Model model) {
		return "report/report-new";
	}
	
}