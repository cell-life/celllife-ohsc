package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 15h34
 */
public final class ClinicAverage implements Serializable {

    private String subDistrictName;

    private String subDistrictShortName;

    private String clinicCode;

    private String clinicShortName;

    private Double staffAttitudeAverage;

    private Double cleanlinessAverage;

    private Double waitingTimesAverage;

    private Double drugAvailabilityAverage;

    private Double infectionControlAverage;

    private Double safeAndSecureCareAverage;

    public ClinicAverage() {
    }

    public ClinicAverage(String subDistrictName, String subDistrictShortName, String clinicCode, String clinicShortName) {
        this.subDistrictName = subDistrictName;
        this.subDistrictShortName = subDistrictShortName;
        this.clinicCode = clinicCode;
        this.clinicShortName = clinicShortName;
    }

    public ClinicAverage(String subDistrictName, String subDistrictShortName, String clinicCode, String clinicShortName,
                         Double staffAttitudeAverage, Double cleanlinessAverage, Double waitingTimesAverage,
                         Double drugAvailabilityAverage, Double infectionControlAverage,
                         Double safeAndSecureCareAverage) {

        this.subDistrictName = subDistrictName;
        this.subDistrictShortName = subDistrictShortName;
        this.clinicCode = clinicCode;
        this.clinicShortName = clinicShortName;
        this.staffAttitudeAverage = staffAttitudeAverage;
        this.cleanlinessAverage = cleanlinessAverage;
        this.waitingTimesAverage = waitingTimesAverage;
        this.drugAvailabilityAverage = drugAvailabilityAverage;
        this.infectionControlAverage = infectionControlAverage;
        this.safeAndSecureCareAverage = safeAndSecureCareAverage;
    }

    public void setSubDistrictShortName(String subDistrictShortName) {
        this.subDistrictShortName = subDistrictShortName;
    }

    public String getSubDistrictShortName() {
        return subDistrictShortName;
    }

    public String getSubDistrictName() {
        return subDistrictName;
    }

    public void setSubDistrictName(String subDistrictName) {
        this.subDistrictName = subDistrictName;
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
