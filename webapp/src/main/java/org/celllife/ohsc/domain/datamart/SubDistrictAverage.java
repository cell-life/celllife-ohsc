package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 15h34
 */
public final class SubDistrictAverage implements Serializable {

    private String districtName;

    private String districtShortName;

    private String subDistrictName;

    private String subDistrictShortName;

    private Double staffAttitudeAverage;

    private Double cleanlinessAverage;

    private Double waitingTimesAverage;

    private Double drugAvailabilityAverage;

    private Double infectionControlAverage;

    private Double safeAndSecureCareAverage;

    public SubDistrictAverage() {
    }

    public SubDistrictAverage(String districtName,
                              String districtShortName,
                              String subDistrictName,
                              String subDistrictShortName) {

        this.districtName = districtName;
        this.districtShortName = districtShortName;
        this.subDistrictName = subDistrictName;
        this.subDistrictShortName = subDistrictShortName;
    }

    public SubDistrictAverage(String districtName, String districtShortName, String subDistrictName,
                              String subDistrictShortName, Double staffAttitudeAverage, Double cleanlinessAverage,
                              Double waitingTimesAverage, Double drugAvailabilityAverage, Double infectionControlAverage,
                              Double safeAndSecureCareAverage) {

        this.districtName = districtName;
        this.districtShortName = districtShortName;
        this.subDistrictName = subDistrictName;
        this.subDistrictShortName = subDistrictShortName;
        this.staffAttitudeAverage = staffAttitudeAverage;
        this.cleanlinessAverage = cleanlinessAverage;
        this.waitingTimesAverage = waitingTimesAverage;
        this.drugAvailabilityAverage = drugAvailabilityAverage;
        this.infectionControlAverage = infectionControlAverage;
        this.safeAndSecureCareAverage = safeAndSecureCareAverage;
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

    public Double getStaffAttitudeAverage() {
        return staffAttitudeAverage;
    }

    public void setStaffAttitudeAverage(Double staffAttitudeAverage) {
        this.staffAttitudeAverage = staffAttitudeAverage;
    }

    public Double getCleanlinessAverage() {
        return cleanlinessAverage;
    }

    public void setCleanlinessAverage(Double cleanlinessAverage) {
        this.cleanlinessAverage = cleanlinessAverage;
    }

    public Double getWaitingTimesAverage() {
        return waitingTimesAverage;
    }

    public void setWaitingTimesAverage(Double waitingTimesAverage) {
        this.waitingTimesAverage = waitingTimesAverage;
    }

    public Double getDrugAvailabilityAverage() {
        return drugAvailabilityAverage;
    }

    public void setDrugAvailabilityAverage(Double drugAvailabilityAverage) {
        this.drugAvailabilityAverage = drugAvailabilityAverage;
    }

    public Double getInfectionControlAverage() {
        return infectionControlAverage;
    }

    public void setInfectionControlAverage(Double infectionControlAverage) {
        this.infectionControlAverage = infectionControlAverage;
    }

    public Double getSafeAndSecureCareAverage() {
        return safeAndSecureCareAverage;
    }

    public void setSafeAndSecureCareAverage(Double safeAndSecureCareAverage) {
        this.safeAndSecureCareAverage = safeAndSecureCareAverage;
    }
}
