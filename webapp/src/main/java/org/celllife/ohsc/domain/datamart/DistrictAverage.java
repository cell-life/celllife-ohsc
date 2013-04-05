package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 15h34
 */
public final class DistrictAverage implements Serializable {

    private String provinceName;

    private String provinceShortName;

    private String districtName;

    private String districtShortName;

    private Double staffAttitudeAverage;

    private Double cleanlinessAverage;

    private Double waitingTimesAverage;

    private Double drugAvailabilityAverage;

    private Double infectionControlAverage;

    private Double safeAndSecureCareAverage;

    public DistrictAverage() {
    }

    public DistrictAverage(String provinceName, String provinceShortName, String districtName, String districtShortName) {

        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.districtName = districtName;
        this.districtShortName = districtShortName;
    }

    public DistrictAverage(String provinceName, String provinceShortName, String districtName, String districtShortName,
                           Double staffAttitudeAverage, Double cleanlinessAverage, Double waitingTimesAverage,
                           Double drugAvailabilityAverage, Double infectionControlAverage, Double safeAndSecureCareAverage) {

        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.districtName = districtName;
        this.districtShortName = districtShortName;
        this.staffAttitudeAverage = staffAttitudeAverage;
        this.cleanlinessAverage = cleanlinessAverage;
        this.waitingTimesAverage = waitingTimesAverage;
        this.drugAvailabilityAverage = drugAvailabilityAverage;
        this.infectionControlAverage = infectionControlAverage;
        this.safeAndSecureCareAverage = safeAndSecureCareAverage;
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
