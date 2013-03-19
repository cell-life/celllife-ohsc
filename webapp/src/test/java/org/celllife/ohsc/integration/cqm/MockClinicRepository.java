package org.celllife.ohsc.integration.cqm;

import org.celllife.ohsc.domain.clinic.Clinic;
import org.celllife.ohsc.domain.clinic.ClinicRepository;
import org.celllife.ohsc.framework.MockPagingAndSortingRepository;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-17
 * Time: 11h49
 */
public class MockClinicRepository extends MockPagingAndSortingRepository<Clinic, Long> implements ClinicRepository {

    @Override
    public Clinic findOneByCode(String code) {
        Clinic clinic = new Clinic();
        clinic.setName("Demo Clinic 1");
        clinic.setCode(code);

        return clinic;
    }

    @Override
    public List<String> findAllCodes() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Clinic findByExternalId(String externalId) {
        return null;
    }

}
