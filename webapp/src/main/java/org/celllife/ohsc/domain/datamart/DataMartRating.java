package org.celllife.ohsc.domain.datamart;

import javax.persistence.*;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-29
 * Time: 10h05
 */
@Entity
@Cacheable
public class DataMartRating {

    @Id
    private String ussdSessionId;

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
    
    private String msisdn;

    private Double staffAttitudeRating;

    private Double cleanlinessRating;

    private Double waitingTimesRating;

    private Double drugAvailabilityRating;

    private Double infectionControlRating;

    private Double safeAndSecureCareRating;

    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;

    public DataMartRating() {
    }

    public String getUssdSessionId() {
        return ussdSessionId;
    }

    public void setUssdSessionId(String ussdSessionId) {
        this.ussdSessionId = ussdSessionId;
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

    public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Double getStaffAttitudeRating() {
        return staffAttitudeRating;
    }

    public void setStaffAttitudeRating(Double staffAttitudeRating) {
        this.staffAttitudeRating = staffAttitudeRating;
    }

    public Double getCleanlinessRating() {
        return cleanlinessRating;
    }

    public void setCleanlinessRating(Double cleanlinessRating) {
        this.cleanlinessRating = cleanlinessRating;
    }

    public Double getWaitingTimesRating() {
        return waitingTimesRating;
    }

    public void setWaitingTimesRating(Double waitingTimesRating) {
        this.waitingTimesRating = waitingTimesRating;
    }

    public Double getDrugAvailabilityRating() {
        return drugAvailabilityRating;
    }

    public void setDrugAvailabilityRating(Double drugAvailabilityRating) {
        this.drugAvailabilityRating = drugAvailabilityRating;
    }

    public Double getInfectionControlRating() {
        return infectionControlRating;
    }

    public void setInfectionControlRating(Double infectionControlRating) {
        this.infectionControlRating = infectionControlRating;
    }

    public Double getSafeAndSecureCareRating() {
        return safeAndSecureCareRating;
    }

    public void setSafeAndSecureCareRating(Double safeAndSecureCareRating) {
        this.safeAndSecureCareRating = safeAndSecureCareRating;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }
}
