package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.country.Country;
import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.datamart.SubDistrictAverageDTO;
import org.celllife.ohsc.domain.district.District;
import org.celllife.ohsc.domain.district.DistrictRepository;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.subdistrict.SubDistrict;
import org.celllife.ohsc.domain.subdistrict.SubDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SubDistrictAverageApplicationServiceImpl implements SubDistrictAverageApplicationService {

    @Autowired
    private SubDistrictRepository subDistrictRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DataMartRatingRepository dataMartRatingRepository;

    public Collection<SubDistrictAverageDTO> findSubDistrictAveragesByDistrict(String districtName, Date startDate, Date endDate) {

        District district = districtRepository.findOneByName(districtName);

        Iterable<SubDistrict> subDistricts = subDistrictRepository.findByDistrictName(districtName);

        Iterable<SubDistrictAverageDTO> subDistrictAverages =
                dataMartRatingRepository.findSubDistrictAveragesByDistrictName(districtName, startDate, endDate);

        Map<String, SubDistrictAverageDTO> subDistrictAverageMap = new HashMap<>();

        for (SubDistrictAverageDTO subDistrictAverageDTO : subDistrictAverages) {
            subDistrictAverageMap.put(subDistrictAverageDTO.getSubDistrictName(), subDistrictAverageDTO);
        }

        Province province = district.getProvince();

        Country country = province.getCountry();

        for (SubDistrict subDistrict : subDistricts) {

            String subDistrictName = subDistrict.getName();
            if (subDistrictAverageMap.get(subDistrictName) == null) {

                SubDistrictAverageDTO subDistrictAverageDTO = new SubDistrictAverageDTO(
                        subDistrictName,
                        subDistrict.getShortName(),
                        districtName,
                        district.getShortName(),
                        province.getName(),
                        province.getShortName(),
                        country.getName(),
                        country.getShortName()
                );
                subDistrictAverageMap.put(subDistrictName, subDistrictAverageDTO);
            }
        }
        
        return subDistrictAverageMap.values();
    }

}
