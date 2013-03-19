package org.celllife.ohsc.integration.dhis;

import org.celllife.ohsc.domain.clinic.Clinic;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 11h47
 */
public interface DhisClinicService {

    List<String> findAllExternalIds();

    Clinic findOne(String externalId);

}
