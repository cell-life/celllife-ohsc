package org.celllife.ohsc.application.totals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.celllife.ohsc.domain.clinic.ClinicRepository;
import org.celllife.ohsc.domain.country.Country;
import org.celllife.ohsc.domain.datamart.DataMartRatingRepository;
import org.celllife.ohsc.domain.datamart.TotalClinicsMonitoredDTO;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.province.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TotalClinicsMonitoredApplicationServiceImpl implements
		TotalClinicsMonitoredApplicationService {

	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Autowired
	private ClinicRepository clinicRepository;

	@Autowired
	private DataMartRatingRepository dataMartRatingRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<TotalClinicsMonitoredDTO> findClinicsMonitoredByProvince(
			String countryName) {

		// get the data for the monitored clinics
		Iterable<TotalClinicsMonitoredDTO> totalClinicsMonitored = dataMartRatingRepository
				.findTotalClinicsMonitoredByProvince(countryName);
		Map<String, TotalClinicsMonitoredDTO> allTotalClinicsMonitored = new HashMap<>();
		for (TotalClinicsMonitoredDTO dto : totalClinicsMonitored) {
			allTotalClinicsMonitored.put(dto.getProvince(), dto);
		}

		// if there are provinces without ratings, create a DTO they will be present in the list
		Iterable<Province> provinces = provinceRepository.findByCountryName(countryName);
		for (Province province : provinces) {
			if (!allTotalClinicsMonitored.containsKey(province.getName())) {
				Country country = province.getCountry();
				TotalClinicsMonitoredDTO dto = new TotalClinicsMonitoredDTO(
						province.getName(), province.getShortName(),
						country.getName(), country.getShortName(), 0l, 0l);
				allTotalClinicsMonitored.put(province.getName(), dto);
			}
		}
		
		// calculate the total clinics in each province
		for (String province : allTotalClinicsMonitored.keySet()) {
			Long totalClinics = clinicRepository.findTotalClinicsByProvinceName(province);
			TotalClinicsMonitoredDTO dto = allTotalClinicsMonitored.get(province);
			dto.setTotalClinics(totalClinics);
		}

		return allTotalClinicsMonitored.values();
	}

}
