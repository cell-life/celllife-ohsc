package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 15h34
 */
public final class ProvinceAverage implements Serializable {

    private String provinceName;

    private String provinceShortName;

    private Double staffAttitudeAverage;

    private Double cleanlinessAverage;

    private Double waitingTimesAverage;

    private Double drugAvailabilityAverage;

    private Double infectionControlAverage;

    private Double safeAndSecureCareAverage;

    public ProvinceAverage() {
    }

    public ProvinceAverage(String provinceName,
                           String provinceShortName) {

        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
    }

    public ProvinceAverage(String provinceName, String provinceShortName, Double staffAttitudeAverage,
                           Double cleanlinessAverage, Double waitingTimesAverage, Double drugAvailabilityAverage,
                           Double infectionControlAverage, Double safeAndSecureCareAverage) {

        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
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
