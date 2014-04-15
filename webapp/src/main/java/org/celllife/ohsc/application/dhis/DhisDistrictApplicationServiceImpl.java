package org.celllife.ohsc.application.dhis;

import org.celllife.ohsc.domain.district.District;
import org.celllife.ohsc.domain.district.DistrictRepository;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.province.ProvinceRepository;
import org.celllife.ohsc.framework.logging.LogLevel;
import org.celllife.ohsc.framework.logging.Loggable;
import org.celllife.ohsc.integration.dhis.DhisDistrictService;
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
public class DhisDistrictApplicationServiceImpl implements DhisDistrictApplicationService {

    @Autowired
    private DhisDistrictService dhisDistrictService;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private Mapper mapper;

    @Loggable(value = LogLevel.INFO, exception = LogLevel.ERROR)
    @Transactional()
    public void synchroniseDistrict(String externalId) {
        District dhisDistrict;
        dhisDistrict = dhisDistrictService.findOne(externalId);

        Province dhisProvince = dhisDistrict.getProvince();
        Province savedProvince = saveProvince(dhisProvince);
        dhisDistrict.setProvince(savedProvince);

        District existingDistrict = districtRepository.findByExternalId(externalId);
        if (existingDistrict == null) {
            districtRepository.save(dhisDistrict);
        } else {
            mapper.map(dhisDistrict, existingDistrict);
            districtRepository.save(existingDistrict);
        }
    }

    private Province saveProvince(Province province) {

        if (province == null || province.getExternalId() == null) {
            return null;
        }

        Province savedProvince = provinceRepository.findByExternalId(province.getExternalId());

        if (savedProvince != null) {
            return savedProvince;
        }

        return provinceRepository.save(province);
    }
}
