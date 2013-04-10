package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.datamart.ProvinceAverageDTO;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.province.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 08h57
 */
@Service
public class ProvinceAverageApplicationServiceImpl implements ProvinceAverageApplicationService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private DataMartRatingRepository dataMartRatingRepository;

    public Collection<ProvinceAverageDTO> findProvinceAverages() {

        Iterable<Province> provinces = provinceRepository.findAll();

        Iterable<ProvinceAverageDTO> provinceAverages =
                dataMartRatingRepository.findProvinceAverages();

        Map<String, ProvinceAverageDTO> provinceAverageMap = new HashMap<>();

        for (ProvinceAverageDTO provinceAverageDTO : provinceAverages) {
            provinceAverageMap.put(provinceAverageDTO.getIdentifier(), provinceAverageDTO);
        }

        for (Province province : provinces) {

            String provinceName = province.getName();
            if (provinceAverageMap.get(provinceName) == null) {

                ProvinceAverageDTO provinceAverageDTO = new ProvinceAverageDTO(
                        provinceName, province.getShortName()
                );
                provinceAverageMap.put(provinceName, provinceAverageDTO);
            }
        }
        
        return provinceAverageMap.values();
    }

}
