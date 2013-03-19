package org.celllife.ohsc.integration.dhis;

import org.celllife.ohsc.domain.province.Province;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-17
 * Time: 18h19
 */
public interface DhisProvinceService {

    List<String> findAllExternalIds();

    Province findOne(String id);
}
