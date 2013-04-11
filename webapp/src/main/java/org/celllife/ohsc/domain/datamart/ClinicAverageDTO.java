package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-09
 * Time: 14h26
 */
public final class ClinicAverageDTO extends AbstractAverageDTO implements Serializable {

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

    public ClinicAverageDTO() {
    }

    public ClinicAverageDTO(String clinicCode, String clinicShortName, String subDistrictName,
                            String subDistrictShortName, String districtName, String districtShortName,
                            String provinceName, String provinceShortName, String countryName,
                            String countryShortName) {

        super();

        this.clinicCode = clinicCode;
        this.clinicShortName = clinicShortName;
        this.subDistrictName = subDistrictName;
        this.subDistrictShortName = subDistrictShortName;
        this.districtName = districtName;
        this.districtShortName = districtShortName;
        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.countryName = countryName;
        this.countryShortName = countryShortName;
    }

    public ClinicAverageDTO(String clinicCode, String clinicShortName, String subDistrictName,
                            String subDistrictShortName, String districtName, String districtShortName,
                            String provinceName, String provinceShortName, String countryName, String countryShortName,
                            Double staffAttitudeRating, Double cleanlinessRating, Double waitingTimesRating,
                            Double drugAvailabilityRating, Double infectionControlRating,
                            Double safeAndSecureCareRating, Long totalResponses) {

        super(staffAttitudeRating, cleanlinessRating, waitingTimesRating, drugAvailabilityRating,
                infectionControlRating, safeAndSecureCareRating, totalResponses);

        this.clinicCode = clinicCode;
        this.clinicShortName = clinicShortName;
        this.subDistrictName = subDistrictName;
        this.subDistrictShortName = subDistrictShortName;
        this.districtName = districtName;
        this.districtShortName = districtShortName;
        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.countryName = countryName;
        this.countryShortName = countryShortName;
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
