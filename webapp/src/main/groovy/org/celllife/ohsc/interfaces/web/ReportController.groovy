package org.celllife.ohsc.interfaces.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import static org.celllife.ohsc.framework.restclient.RESTClient.get
/**
 * User: Kevin W. Sewell
 * Date: 2013-03-28
 * Time: 09h49
 */
@Controller
class ReportController {

    @Value('${averages.url}')
    def String averagesUrl;

    @RequestMapping(value="/reports/provinces", method = RequestMethod.GET)
    def findProvinceAverages(Model model) {

        def averages = get("${averagesUrl}/findProvinceAverages")

        model.put("averages", averages)

        return "report/report";
    }

    @RequestMapping(value="/reports/districts", method = RequestMethod.GET)
    def findDistrictAveragesByProvince(String province, Model model) {

        def averages = get("${averagesUrl}/findDistrictAveragesByProvince", query: [ province:province ])

        model.put("averages", averages)

        return "report/report-new";
    }
}
