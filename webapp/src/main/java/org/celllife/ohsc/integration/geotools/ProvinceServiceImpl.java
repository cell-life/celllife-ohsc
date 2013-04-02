package org.celllife.ohsc.integration.geotools;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.filter.text.cql2.CQL;
import org.geotools.filter.text.cql2.CQLException;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.filter.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * User: Kevin W. Sewell
 * Date: 2013-02-10
 * Time: 19h23
 */
@Repository
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private SimpleFeatureSource provinceFeatureSource;

    @Override
    public SimpleFeatureCollection findAll() {

        try {
            return provinceFeatureSource.getFeatures();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SimpleFeature findByCode(String code) {
        return findOne("CODE='%s'", code);
    }

    @Override
    public SimpleFeature findByName(String name) {
        return findOne("PROVINCE='%s'", name);

    }

    private SimpleFeature findOne(String cql, String code) {

        Filter filter = filter(cql, code);

        SimpleFeatureCollection simpleFeatures = getFeatures(filter);

        return simpleFeatures.size() == 0 ? null : simpleFeatures.features().next();
    }

    private SimpleFeatureCollection getFeatures(Filter filter) {
        try {
            return provinceFeatureSource.getFeatures(filter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Filter filter(String cql, String... params)  {
        try {
            return CQL.toFilter(String.format(cql, ((Object[]) params)));
        } catch (CQLException e) {
            throw new RuntimeException(e);
        }
    }
}
