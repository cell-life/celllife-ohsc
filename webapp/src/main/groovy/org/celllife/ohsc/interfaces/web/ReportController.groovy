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
    def index(Model model) {

        model.putAt("provinces", get("${baseUri}/api/provinces"))

        return "report/index";
    }

    def static get(String uri) {
        return new RESTClient(uri).get().data
    }
}
