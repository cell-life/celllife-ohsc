package org.celllife.ohsc.application.averages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.celllife.ohsc.domain.country.Country;
import org.celllife.ohsc.domain.country.CountryRepository;
import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.datamart.ProvinceAverageDTO;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.province.ProvinceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 08h57
 */
@Service
public class ProvinceAverageApplicationServiceImpl implements ProvinceAverageApplicationService {
	
	private static Logger log = LoggerFactory.getLogger(ProvinceAverageApplicationServiceImpl.class);

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private DataMartRatingRepository dataMartRatingRepository;

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public Collection<ProvinceAverageDTO> findOneProvinceAverageByCountryName(String countryName, String provinceName, Date startDate, Date endDate) {
    	List<ProvinceAverageDTO> provinces = new ArrayList<ProvinceAverageDTO>();
    	
        Province province = provinceRepository.findOneByName(provinceName);
        
        if (province != null) {
        	ProvinceAverageDTO provinceAverage =
	                dataMartRatingRepository.findOneProvinceAverageByCountryNameAndProvinceName(countryName, province.getName(), startDate, endDate);
	        if (provinceAverage == null) {
	        	provinceAverage = new ProvinceAverageDTO(
                        provinceName,
                        province.getShortName(),
                        province.getCountry().getName(),
                        province.getCountry().getShortName()
                );
	        }
	        provinces.add(provinceAverage);
        }
        
        return provinces;
    }

}
