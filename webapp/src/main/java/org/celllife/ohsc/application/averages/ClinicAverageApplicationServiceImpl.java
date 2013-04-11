package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.clinic.Clinic;
import org.celllife.ohsc.domain.clinic.ClinicRepository;
import org.celllife.ohsc.domain.country.Country;
import org.celllife.ohsc.domain.datamart.ClinicAverageDTO;
import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.district.District;
import org.celllife.ohsc.domain.province.Province;
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

    public Collection<ClinicAverageDTO> findClinicAveragesBySubDistrict(String subDistrictName) {

        SubDistrict subDistrict = subDistrictRepository.findOneByName(subDistrictName);

        Iterable<Clinic> clinics = clinicRepository.findBySubDistrictName(subDistrictName);

        Iterable<ClinicAverageDTO> clinicAverages =
                dataMartRatingRepository.findClinicAveragesBySubDistrictName(subDistrictName);

        Map<String, ClinicAverageDTO> clinicAverageMap = new HashMap<>();

        for (ClinicAverageDTO clinicAverageDTO : clinicAverages) {
            clinicAverageMap.put(clinicAverageDTO.getClinicCode(), clinicAverageDTO);
        }

        District district = subDistrict.getDistrict();

        Province province = district.getProvince();

        Country country = province.getCountry();

        for (Clinic clinic : clinics) {

            String clinicCode = clinic.getCode();
            if (clinicAverageMap.get(clinicCode) == null) {

                ClinicAverageDTO clinicAverageDTO = new ClinicAverageDTO(
                        clinicCode,
                        clinic.getShortName(),
                        subDistrictName,
                        subDistrict.getShortName(),
                        district.getName(),
                        district.getShortName(),
                        province.getName(),
                        province.getShortName(),
                        country.getName(),
                        country.getShortName()
                );
                clinicAverageMap.put(clinicCode, clinicAverageDTO);
            }
        }
        
        return clinicAverageMap.values();
    }

}
