package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.country.Country;
import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.datamart.DistrictAverageDTO;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.province.ProvinceRepository;
import org.celllife.ohsc.domain.district.District;
import org.celllife.ohsc.domain.district.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
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

    @Transactional(readOnly = true)
    public Collection<DistrictAverageDTO> findDistrictAveragesByProvince(String provinceName, Date startDate, Date endDate) {

        Province province = provinceRepository.findOneByName(provinceName);

        Iterable<District> districts = districtRepository.findByProvinceName(provinceName);

        Iterable<DistrictAverageDTO> districtAverages =
                dataMartRatingRepository.findDistrictAveragesByProvinceName(provinceName, startDate, endDate);

        Map<String, DistrictAverageDTO> districtAverageMap = new HashMap<>();

        for (DistrictAverageDTO districtAverageDTO : districtAverages) {
            districtAverageMap.put(districtAverageDTO.getDistrictName(), districtAverageDTO);
        }

        Country country = province.getCountry();

        for (District district : districts) {

            String districtName = district.getName();
            if (districtAverageMap.get(districtName) == null) {

                DistrictAverageDTO districtAverageDTO = new DistrictAverageDTO(
                        districtName,
                        district.getShortName(),
                        provinceName,
                        province.getShortName(),
                        country.getName(),
                        country.getShortName()
                );
                districtAverageMap.put(districtName, districtAverageDTO);
            }
        }
        
        return districtAverageMap.values();
    }

}
