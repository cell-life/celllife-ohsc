package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 15h34
 */
public final class ClinicAverages implements Serializable {

    private String clinic;

    private Double staffAttitudeAverage;

    public ClinicAverages() {
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public Double getStaffAttitudeAverage() {
        return staffAttitudeAverage;
    }

    public void setStaffAttitudeAverage(Double staffAttitudeAverage) {
        this.staffAttitudeAverage = staffAttitudeAverage;
    }
}
