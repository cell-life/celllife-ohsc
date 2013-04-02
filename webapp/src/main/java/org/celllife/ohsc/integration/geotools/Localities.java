package org.celllife.ohsc.integration.geotools;

import org.opengis.feature.simple.SimpleFeature;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-29
 * Time: 11h08
 */
public final class Localities {

    private Localities() {
    }

    public static String getName(SimpleFeature simpleFeature) {
        return (String) simpleFeature.getAttribute("MUNICNAME");
    }

    public static String getCode(SimpleFeature simpleFeature) {
        return (String) simpleFeature.getAttribute("CAT_B");
    }

    public static String getDistrictCode(SimpleFeature simpleFeature) {
        return (String) simpleFeature.getAttribute("DISTRICT");
    }

    public static String getProvinceCode(SimpleFeature simpleFeature) {
        return (String) simpleFeature.getAttribute("PROVINCE");
    }
}
