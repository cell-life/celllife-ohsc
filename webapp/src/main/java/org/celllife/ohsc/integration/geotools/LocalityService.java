package org.celllife.ohsc.integration.geotools;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.opengis.feature.simple.SimpleFeature;

/**
 * User: Kevin W. Sewell
 * Date: 2013-02-10
 * Time: 19h02
 */
public interface LocalityService {

    SimpleFeatureCollection findAll();

    SimpleFeature findByCode(String code);

    SimpleFeatureCollection findByNameLike(String name);

    SimpleFeatureCollection findByDistrict(String district);

    SimpleFeatureCollection findByProvince(String province);

}
