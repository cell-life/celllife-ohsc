package org.celllife.ohsc.application.dhis;

import org.celllife.ohsc.domain.district.District;
import org.celllife.ohsc.domain.district.DistrictRepository;
import org.celllife.ohsc.domain.subdistrict.SubDistrict;
import org.celllife.ohsc.domain.subdistrict.SubDistrictRepository;
import org.celllife.ohsc.framework.logging.LogLevel;
import org.celllife.ohsc.framework.logging.Loggable;
import org.celllife.ohsc.integration.dhis.DhisSubDistrictService;
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
public class DhisSubDistrictApplicationServiceImpl implements DhisSubDistrictApplicationService {

    @Autowired
    private DhisSubDistrictService dhisSubDistrictService;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private SubDistrictRepository subDistrictRepository;

    @Autowired
    private Mapper mapper;

    @Loggable(value = LogLevel.INFO, exception = LogLevel.ERROR)
    @Transactional()
    public void synchroniseSubDistrict(String externalId) {
        SubDistrict dhisSubDistrict;
        dhisSubDistrict = dhisSubDistrictService.findOne(externalId);

        District dhisDistrict = dhisSubDistrict.getDistrict();
        District savedDistrict = saveDistrict(dhisDistrict);
        dhisSubDistrict.setDistrict(savedDistrict);

        SubDistrict existingSubDistrict = subDistrictRepository.findByExternalId(externalId);
        if (existingSubDistrict == null) {
            subDistrictRepository.save(dhisSubDistrict);
        } else {
            mapper.map(dhisSubDistrict, existingSubDistrict);
            subDistrictRepository.save(existingSubDistrict);
        }
    }

    private District saveDistrict(District district) {

        if (district == null || district.getExternalId() == null) {
            return null;
        }

        District savedDistrict = districtRepository.findByExternalId(district.getExternalId());

        if (savedDistrict != null) {
            return savedDistrict;
        }

        return districtRepository.save(district);
    }
}
