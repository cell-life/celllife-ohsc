package org.celllife.ohsc.integration.geotools;

import org.opengis.feature.simple.SimpleFeature;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-29
 * Time: 11h08
 */
public final class Districts {

    private Districts() {
    }

    public static String getName(SimpleFeature simpleFeature) {
        return (String) simpleFeature.getAttribute("MUNICNAME");
    }

    public static String getCode(SimpleFeature simpleFeature) {
        return (String) simpleFeature.getAttribute("DISTRICT");
    }

    public static String getProvinceCode(SimpleFeature simpleFeature) {
        return (String) simpleFeature.getAttribute("PROVINCE");
    }

    public static String getProvinceName(SimpleFeature simpleFeature) {
        return (String) simpleFeature.getAttribute("PROVNAME");
    }
}
