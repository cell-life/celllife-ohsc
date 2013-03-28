package org.celllife.ohsc.interfaces.web

import groovyx.net.http.RESTClient
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
@RequestMapping("/reports")
class ReportController {

    @Value('${base.uri}')
    def String baseUri;

    @RequestMapping(method = RequestMethod.GET)
    String index(Model model) {

        def api = new RESTClient("${baseUri}/api")

        def provinces = api.get(path: "provinces").data

        model.putAt("provinces", provinces)

        return "report/index";
    }

}
