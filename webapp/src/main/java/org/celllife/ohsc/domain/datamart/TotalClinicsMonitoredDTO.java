package org.celllife.ohsc.domain.datamart;

/**
 * Data Transfer Object containing data showing the total number of clinics and
 * total clinics being monitored per province.
 */
public class TotalClinicsMonitoredDTO {

	private String province;
	private String provinceShortName;
	private String country;
	private String countryShortName;

	private Long totalClinics;
	private Long totalClinicsMonitored;

	public TotalClinicsMonitoredDTO(String province, String provinceShortName,
			String country, String countryShortName, Long totalClinics,
			Long totalClinicsMonitored) {
		this.province = province;
		this.provinceShortName = provinceShortName;
		this.totalClinics = totalClinics;
		this.totalClinicsMonitored = totalClinicsMonitored;
		this.country = country;
		this.countryShortName = countryShortName;
	}

	public TotalClinicsMonitoredDTO(String province, String provinceShortName,
			String country, String countryShortName,
			Long totalClinicsMonitored) {
		this.province = province;
		this.provinceShortName = provinceShortName;
		this.totalClinicsMonitored = totalClinicsMonitored;
		this.country = country;
		this.countryShortName = countryShortName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvinceShortName() {
		return provinceShortName;
	}

	public void setProvinceShortName(String provinceShortName) {
		this.provinceShortName = provinceShortName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryShortName() {
		return countryShortName;
	}

	public void setCountryShortName(String countryShortName) {
		this.countryShortName = countryShortName;
	}

	public Long getTotalClinics() {
		return totalClinics;
	}

	public void setTotalClinics(Long totalClinics) {
		this.totalClinics = totalClinics;
	}

	public Long getTotalClinicsMonitored() {
		return totalClinicsMonitored;
	}

	public void setTotalClinicsMonitored(Long totalClinicsMonitored) {
		this.totalClinicsMonitored = totalClinicsMonitored;
	}

}
