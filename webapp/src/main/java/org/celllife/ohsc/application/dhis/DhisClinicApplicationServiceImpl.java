package org.celllife.ohsc.application.dhis;

import org.celllife.ohsc.domain.clinic.Clinic;
import org.celllife.ohsc.domain.clinic.ClinicRepository;
import org.celllife.ohsc.domain.subdistrict.SubDistrict;
import org.celllife.ohsc.domain.subdistrict.SubDistrictRepository;
import org.celllife.ohsc.framework.logging.LogLevel;
import org.celllife.ohsc.framework.logging.Loggable;
import org.celllife.ohsc.integration.aat.AatClinicService;
import org.celllife.ohsc.integration.dhis.DhisClinicService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 10h15
 */
@Service
public class DhisClinicApplicationServiceImpl implements DhisClinicApplicationService {

    @Autowired
    private DhisClinicService dhisClinicService;

    @Autowired
    private AatClinicService aatClinicService;

    @Autowired
    private SubDistrictRepository subDistrictRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private Mapper mapper;

    @Loggable(value = LogLevel.INFO, exception = LogLevel.ERROR)
    @Transactional()
    public void synchroniseClinic(String externalId) {

        Clinic dhisClinic = dhisClinicService.findOne(externalId);

        if (dhisClinic == null) {
            return;
        }

        // Wire up Sub-District
        SubDistrict dhisSubDistrict = dhisClinic.getSubDistrict();
        SubDistrict savedSubDistrict = saveSubDistrict(dhisSubDistrict);
        dhisClinic.setSubDistrict(savedSubDistrict);

        // Inject Clinic Code from AAT
        String clinicCode = aatClinicService.findClinicCodeByShortName(dhisClinic.getShortName());
        dhisClinic.setCode(clinicCode);

        // Check if clinic already exists
        Clinic existingClinic = clinicRepository.findByExternalId(externalId);

        if (existingClinic == null) {

            // Save new clinic
            clinicRepository.save(dhisClinic);
        } else {

            // Merge incoming clinic with existing
            mapper.map(dhisClinic, existingClinic);
            clinicRepository.save(existingClinic);
        }
    }

    private SubDistrict saveSubDistrict(SubDistrict subDistrict) {

        if (subDistrict == null || subDistrict.getExternalId() == null) {
            return null;
        }

        SubDistrict savedSubDistrict = subDistrictRepository.findByExternalId(subDistrict.getExternalId());

        if (savedSubDistrict != null) {
            return savedSubDistrict;
        }

        return subDistrictRepository.save(subDistrict);
    }
}
