package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.clinic.Clinic;
import org.celllife.ohsc.domain.clinic.ClinicRepository;
import org.celllife.ohsc.domain.datamart.ClinicAverageDTO;
import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
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
            clinicAverageMap.put(clinicAverageDTO.getIdentifier(), clinicAverageDTO);
        }

        for (Clinic clinic : clinics) {

            String clinicCode = clinic.getCode();
            if (clinicAverageMap.get(clinicCode) == null) {

                ClinicAverageDTO clinicAverageDTO = new ClinicAverageDTO(
                        clinic.getShortName(), clinicCode,
                        subDistrictName,
                        subDistrict.getShortName()
                );
                clinicAverageMap.put(clinicCode, clinicAverageDTO);
            }
        }
        
        return clinicAverageMap.values();
    }

}
