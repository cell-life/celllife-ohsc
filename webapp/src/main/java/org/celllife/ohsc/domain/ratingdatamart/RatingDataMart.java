package org.celllife.ohsc.domain.ratingdatamart;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-29
 * Time: 10h05
 */
@Entity
@Cacheable
public final class RatingDataMart {

    @Id
    private String ussdSessionId;

    private String clinic;

    private String subDistrict;

    private String district;

    private String province;

    private Double staffAttitudeRating;

    private Double cleanlinessRating;

    private Double waitingTimesRating;

    private Double drugAvailabilityRating;

    private Double infectionControlRating;

    private Double safeAndSecureCareRating;

    public RatingDataMart() {
    }

    public String getUssdSessionId() {
        return ussdSessionId;
    }

    public void setUssdSessionId(String ussdSessionId) {
        this.ussdSessionId = ussdSessionId;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public void setSafeAndSecureCareRating(Double safetyAndSecurityRating) {
        this.safeAndSecureCareRating = safetyAndSecurityRating;
    }
}
