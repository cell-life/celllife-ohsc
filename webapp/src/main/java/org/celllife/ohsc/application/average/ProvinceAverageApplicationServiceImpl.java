package org.celllife.ohsc.application.average;

import org.celllife.ohsc.application.average.dto.ProvinceAverage;
import org.celllife.ohsc.domain.average.ClinicAverage;
import org.celllife.ohsc.domain.average.ClinicAverageRepository;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.province.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-19
 * Time: 13h31
 */
@Service("provinceAverageApplicationService")
public class ProvinceAverageApplicationServiceImpl implements ProvinceAverageApplicationService {

    @Autowired
    private ClinicAverageRepository clinicAverageRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    public Set<ProvinceAverage> findProvincialAverages() {

        Set<ProvinceAverage> provinceAverages = new HashSet<>();

        Iterable<Province> provinces = provinceRepository.findAll();
        for (Province province : provinces) {

            ProvinceAverage provinceAverage = new ProvinceAverage();

            Iterable<ClinicAverage> clinicAverages = clinicAverageRepository.findByProvince(province);
            for (ClinicAverage clinicAverage : clinicAverages) {
                provinceAverage.addClinicAverage(clinicAverage);
            }

            provinceAverages.add(provinceAverage);
        }

        return provinceAverages;
    }
}
