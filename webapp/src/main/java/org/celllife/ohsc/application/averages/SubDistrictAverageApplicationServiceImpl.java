package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.datamart.SubDistrictAverage;
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

    public Collection<SubDistrictAverage> findSubDistrictAveragesByDistrict(String districtName) {

        District district = districtRepository.findOneByName(districtName);

        Iterable<SubDistrict> subDistricts = subDistrictRepository.findByDistrictName(districtName);

        Iterable<SubDistrictAverage> subDistrictAverages =
                dataMartRatingRepository.findSubDistrictAveragesByDistrictName(districtName);

        Map<String, SubDistrictAverage> subDistrictAverageMap = new HashMap<>();

        for (SubDistrictAverage subDistrictAverage : subDistrictAverages) {
            subDistrictAverageMap.put(subDistrictAverage.getSubDistrictName(), subDistrictAverage);
        }

        for (SubDistrict subDistrict : subDistricts) {

            String subDistrictName = subDistrict.getName();
            if (subDistrictAverageMap.get(subDistrictName) == null) {

                SubDistrictAverage subDistrictAverage = new SubDistrictAverage(
                        districtName,
                        district.getShortName(),
                        subDistrictName,
                        subDistrict.getShortName()
                );
                subDistrictAverageMap.put(subDistrictName, subDistrictAverage);
            }
        }
        
        return subDistrictAverageMap.values();
    }

}
