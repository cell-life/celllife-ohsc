package org.celllife.ohsc.application.averages;

import org.celllife.ohsc.domain.country.Country;
import org.celllife.ohsc.domain.country.CountryRepository;
import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.datamart.ProvinceAverageDTO;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.province.ProvinceRepository;
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
public class ProvinceAverageApplicationServiceImpl implements ProvinceAverageApplicationService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private DataMartRatingRepository dataMartRatingRepository;

    public Collection<ProvinceAverageDTO> findProvinceAveragesByCountryName(String countryName, Date startDate, Date endDate) {

        Country country = countryRepository.findOneByName(countryName);

        Iterable<Province> provinces = provinceRepository.findByCountryName(countryName);

        Iterable<ProvinceAverageDTO> provinceAverages =
                dataMartRatingRepository.findProvinceAveragesByCountryName(countryName, startDate, endDate);

        Map<String, ProvinceAverageDTO> provinceAverageMap = new HashMap<>();

        for (ProvinceAverageDTO provinceAverageDTO : provinceAverages) {
            provinceAverageMap.put(provinceAverageDTO.getProvinceName(), provinceAverageDTO);
        }

        for (Province province : provinces) {

            String provinceName = province.getName();
            if (provinceAverageMap.get(provinceName) == null) {

                ProvinceAverageDTO provinceAverageDTO = new ProvinceAverageDTO(
                        provinceName,
                        province.getShortName(),
                        countryName,
                        country.getShortName()
                );
                provinceAverageMap.put(provinceName, provinceAverageDTO);
            }
        }
        
        return provinceAverageMap.values();
    }

}
