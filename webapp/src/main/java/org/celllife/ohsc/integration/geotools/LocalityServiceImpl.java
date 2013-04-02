package org.celllife.ohsc.integration.geotools;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.filter.text.cql2.CQL;
import org.geotools.filter.text.cql2.CQLException;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.filter.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * User: Kevin W. Sewell
 * Date: 2013-02-10
 * Time: 19h08
 */
@Service
public class LocalityServiceImpl implements LocalityService {

    @Autowired
    private SimpleFeatureSource localityFeatureSource;

    @Override
    public SimpleFeatureCollection findAll() {

        try {
            return localityFeatureSource.getFeatures();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SimpleFeature findByCode(String code) {
        return findOne("CAT_B='%s'", code);
    }

    @Override
    public SimpleFeatureCollection findByNameLike(String name) {
        return find("MUNICNAME like '%s%%'", name);
    }

    @Override
    public SimpleFeatureCollection findByDistrict(String province) {
        return find("DISTRICT='%s'", province);
    }

    @Override
    public SimpleFeatureCollection findByProvince(String province) {
        return find("PROVINCE='%s'", province);
    }

    private SimpleFeature findOne(String cql, String code) {

        SimpleFeatureCollection simpleFeatures = find(cql, code);

        return simpleFeatures.size() == 0 ? null : simpleFeatures.features().next();
    }

    private SimpleFeatureCollection find(String cql, String code) {

        Filter filter = filter(cql, code);

        try {
            return localityFeatureSource.getFeatures(filter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Filter filter(String cql, String... params)  {

        try {
            String cqlPredicate = String.format(cql, ((Object[]) params));
            return CQL.toFilter(cqlPredicate);
        } catch (CQLException e) {
            throw new RuntimeException(e);
        }
    }
}