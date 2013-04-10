package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.datamart.SubDistrictAverageDTO;
import org.celllife.ohsc.domain.district.District;
import org.celllife.ohsc.domain.district.DistrictRepository;
import org.celllife.ohsc.domain.subdistrict.SubDistrict;
import org.celllife.ohsc.domain.subdistrict.SubDistrictRepository;
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
public class SubDistrictAverageApplicationServiceImpl implements SubDistrictAverageApplicationService {

    @Autowired
    private SubDistrictRepository subDistrictRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DataMartRatingRepository dataMartRatingRepository;

    public Collection<SubDistrictAverageDTO> findSubDistrictAveragesByDistrict(String districtName) {

        District district = districtRepository.findOneByName(districtName);

        Iterable<SubDistrict> subDistricts = subDistrictRepository.findByDistrictName(districtName);

        Iterable<SubDistrictAverageDTO> subDistrictAverages =
                dataMartRatingRepository.findSubDistrictAveragesByDistrictName(districtName);

        Map<String, SubDistrictAverageDTO> subDistrictAverageMap = new HashMap<>();

        for (SubDistrictAverageDTO subDistrictAverageDTO : subDistrictAverages) {
            subDistrictAverageMap.put(subDistrictAverageDTO.getIdentifier(), subDistrictAverageDTO);
        }

        for (SubDistrict subDistrict : subDistricts) {

            String subDistrictName = subDistrict.getName();
            if (subDistrictAverageMap.get(subDistrictName) == null) {

                SubDistrictAverageDTO subDistrictAverageDTO = new SubDistrictAverageDTO(
                        subDistrictName,
                        subDistrict.getShortName(),
                        districtName,
                        district.getShortName()
                );
                subDistrictAverageMap.put(subDistrictName, subDistrictAverageDTO);
            }
        }
        
        return subDistrictAverageMap.values();
    }

}
