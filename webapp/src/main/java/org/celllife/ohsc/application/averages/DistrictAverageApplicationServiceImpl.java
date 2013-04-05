package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.datamart.DistrictAverage;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.province.ProvinceRepository;
import org.celllife.ohsc.domain.district.District;
import org.celllife.ohsc.domain.district.DistrictRepository;
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
public class DistrictAverageApplicationServiceImpl implements DistrictAverageApplicationService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private DataMartRatingRepository dataMartRatingRepository;

    public Collection<DistrictAverage> findDistrictAveragesByProvince(String provinceName) {

        Province province = provinceRepository.findOneByName(provinceName);

        Iterable<District> districts = districtRepository.findByProvinceName(provinceName);

        Iterable<DistrictAverage> districtAverages =
                dataMartRatingRepository.findDistrictAveragesByProvinceName(provinceName);

        Map<String, DistrictAverage> districtAverageMap = new HashMap<>();

        for (DistrictAverage districtAverage : districtAverages) {
            districtAverageMap.put(districtAverage.getDistrictName(), districtAverage);
        }

        for (District district : districts) {

            String districtName = district.getName();
            if (districtAverageMap.get(districtName) == null) {

                DistrictAverage districtAverage = new DistrictAverage(
                        provinceName,
                        province.getShortName(),
                        districtName,
                        district.getShortName()
                );
                districtAverageMap.put(districtName, districtAverage);
            }
        }
        
        return districtAverageMap.values();
    }

}
