package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 15h34
 */
public final class DistrictAverageDTO extends AbstractAverageDTO implements Serializable {

    private String districtName;

    private String districtShortName;

    private String provinceName;

    private String provinceShortName;

    private String countryName;

    private String countryShortName;

    public DistrictAverageDTO() {
    }

    public DistrictAverageDTO(String districtName, String districtShortName, String provinceName,
                              String provinceShortName, String countryName, String countryShortName) {

        super();

        this.districtName = districtName;
        this.districtShortName = districtShortName;
        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.countryName = countryName;
        this.countryShortName = countryShortName;
    }

    public DistrictAverageDTO(String districtName, String districtShortName, String provinceName,
                              String provinceShortName, String countryName, String countryShortName,
                              Double staffAttitudeRating, Double cleanlinessRating, Double waitingTimesRating,
                              Double drugAvailabilityRating, Double infectionControlRating,
                              Double safeAndSecureCareRating, Long totalResponses) {

        super(staffAttitudeRating, cleanlinessRating, waitingTimesRating, drugAvailabilityRating,
                infectionControlRating, safeAndSecureCareRating, totalResponses);

        this.districtName = districtName;
        this.districtShortName = districtShortName;
        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.countryName = countryName;
        this.countryShortName = countryShortName;
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
