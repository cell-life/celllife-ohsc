package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.clinic.Clinic;
import org.celllife.ohsc.domain.clinic.ClinicRepository;
import org.celllife.ohsc.domain.datamart.ClinicAverage;
import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.district.DistrictRepository;
import org.celllife.ohsc.domain.province.ProvinceRepository;
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
public class ClinicAverageApplicationServiceImpl implements ClinicAverageApplicationService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private SubDistrictRepository subDistrictRepository;

    @Autowired
    private DataMartRatingRepository dataMartRatingRepository;

    public Collection<ClinicAverage> findClinicAveragesBySubDistrict(String subDistrictName) {

        SubDistrict subDistrict = subDistrictRepository.findOneByName(subDistrictName);

        Iterable<Clinic> clinics = clinicRepository.findBySubDistrictName(subDistrictName);

        Iterable<ClinicAverage> clinicAverages =
                dataMartRatingRepository.findClinicAveragesBySubDistrictName(subDistrictName);

        Map<String, ClinicAverage> clinicAverageMap = new HashMap<>();

        for (ClinicAverage clinicAverage : clinicAverages) {
            clinicAverageMap.put(clinicAverage.getClinicCode(), clinicAverage);
        }

        for (Clinic clinic : clinics) {

            String clinicCode = clinic.getCode();
            if (clinicAverageMap.get(clinicCode) == null) {

                ClinicAverage clinicAverage = new ClinicAverage(
                        subDistrictName,
                        subDistrict.getShortName(),
                        clinicCode,
                        clinic.getShortName()
                );
                clinicAverageMap.put(clinicCode, clinicAverage);
            }
        }
        
        return clinicAverageMap.values();
    }

}
