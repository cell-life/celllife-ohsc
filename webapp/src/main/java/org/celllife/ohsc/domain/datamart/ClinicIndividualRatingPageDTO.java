package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * DTO containing a page of individual clinic ratings, in DataTables format.
 * 
 * See more information here: http://www.datatables.net/usage/server-side
 * And http://datatables.net/development/server-side/jsp
 */
public class ClinicIndividualRatingPageDTO implements Serializable {

	private static final long serialVersionUID = 1227805378326624665L;

	private String sEcho;
	
	private Integer iTotalRecords;
	
	private Integer iTotalDisplayRecords;

	private String clinicCode;

    private String clinicShortName;

    private String subDistrictName;

    private String subDistrictShortName;

    private String districtName;

    private String districtShortName;

    private String provinceName;

    private String provinceShortName;

    private String countryName;

    private String countryShortName;
	
	private Object[][] aaData;

    public ClinicIndividualRatingPageDTO() {
    }

    public ClinicIndividualRatingPageDTO(String sEcho, Integer iTotalRecords, Integer iTotalDisplayRecords, Object[][] aaData) {
    	this.sEcho = sEcho;
    	this.iTotalRecords = iTotalRecords;
    	this.iTotalDisplayRecords = iTotalDisplayRecords;
    	this.aaData = aaData;
    }

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public Integer getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public Object[][] getAaData() {
		return aaData;
	}

	public void setAaData(Object[][] aaData) {
		this.aaData = aaData;
	}

	public String getClinicCode() {
		return clinicCode;
	}

	public void setClinicCode(String clinicCode) {
		this.clinicCode = clinicCode;
	}

	public String getClinicShortName() {
		return clinicShortName;
	}

	public void setClinicShortName(String clinicShortName) {
		this.clinicShortName = clinicShortName;
	}

	public String getSubDistrictName() {
		return subDistrictName;
	}

	public void setSubDistrictName(String subDistrictName) {
		this.subDistrictName = subDistrictName;
	}

	public String getSubDistrictShortName() {
		return subDistrictShortName;
	}

	public void setSubDistrictShortName(String subDistrictShortName) {
		this.subDistrictShortName = subDistrictShortName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictShortName() {
		return districtShortName;
	}

	public void setDistrictShortName(String districtShortName) {
		this.districtShortName = districtShortName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceShortName() {
		return provinceShortName;
	}

	public void setProvinceShortName(String provinceShortName) {
		this.provinceShortName = provinceShortName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryShortName() {
		return countryShortName;
	}

	public void setCountryShortName(String countryShortName) {
		this.countryShortName = countryShortName;
	}
}
