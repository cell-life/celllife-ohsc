package org.celllife.ohsc.interfaces.web.geo;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.simplify.DouglasPeuckerSimplifier;
import org.celllife.ohsc.integration.geotools.DistrictService;
import org.celllife.ohsc.integration.geotools.LocalityService;
import org.celllife.ohsc.integration.geotools.ProvinceService;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.geojson.GeoJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.StringWriter;

/**
 * User: Kevin W. Sewell
 * Date: 2013-02-10
 * Time: 08h34
 */
@Controller
@RequestMapping("/services/geo")
public class GeoController {

    private static final String ALL = "ALL";

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private LocalityService localityService;

    @ResponseBody
    @RequestMapping(value = "/provinces/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findAllProvinces() {
        return json(simplify(provinceService.findAll()));
    }

    @ResponseBody
    @RequestMapping(value = "/provinces/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findProvinceByCode(@PathVariable(value = "code") String code) {
        return json(simplify((SimpleFeatureCollection) provinceService.findByCode(code)));
    }

    @ResponseBody
    @RequestMapping(value = "/districts/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findAllDistricts() {
        return json(simplify(districtService.findAll()));
    }

    @ResponseBody
    @RequestMapping(value = "/districts/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findDistrictByCode(@PathVariable(value = "code") String code) {
        return json(simplify(districtService.findByCode(code)));
    }

    @ResponseBody
    @RequestMapping(value = "/districts/findByProvince", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findDistrictsByProvince(@RequestParam(value = "province") String province) {
        return json(simplify(districtService.findByProvince(province)));
    }

    @ResponseBody
    @RequestMapping(value = "/localities/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findAllLocalities() {
        return json(simplify(localityService.findAll()));
    }

    @ResponseBody
    @RequestMapping(value = "/localities/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findLocalityByCode(@PathVariable(value = "code") String code) {
        return json(simplify(localityService.findByCode(code)));
    }

    @ResponseBody
    @RequestMapping(value = "/localities/findByDistrict", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findLocalitiesByDistrict(@RequestParam(value = "district") String district) {
        return json(simplify(localityService.findByDistrict(district)));
    }

    @ResponseBody
    @RequestMapping(value = "/localities/findByProvince", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findLocalitiesByProvince(@RequestParam(value = "province") String province) {
        return json(simplify(localityService.findByProvince(province)));
    }

    private SimpleFeatureCollection simplify(SimpleFeatureCollection simpleFeatureCollection) {

        SimpleFeatureIterator simpleFeatureIterator = simpleFeatureCollection.features();
        while (simpleFeatureIterator.hasNext()) {
            SimpleFeature simpleFeature = simpleFeatureIterator.next();
            simplify(simpleFeature);
        }

        return simpleFeatureCollection;
    }

    private SimpleFeature simplify(SimpleFeature simpleFeature) {

        Object defaultGeometry = simpleFeature.getDefaultGeometry();

        DouglasPeuckerSimplifier douglasPeuckerSimplifier = new DouglasPeuckerSimplifier((Geometry) defaultGeometry);
        douglasPeuckerSimplifier.setDistanceTolerance(0.1);
        simpleFeature.setDefaultGeometry(douglasPeuckerSimplifier.getResultGeometry());

        return simpleFeature;
    }

    private static String json(SimpleFeatureCollection simpleFeatureCollection) {

        StringWriter stringWriter = new StringWriter();

        try {
            GeoJSON.write(simpleFeatureCollection, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String json(SimpleFeature simpleFeature) {

        StringWriter stringWriter = new StringWriter();

        try {
            GeoJSON.write(simpleFeature, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
