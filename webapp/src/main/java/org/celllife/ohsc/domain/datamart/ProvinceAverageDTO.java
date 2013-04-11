package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 15h34
 */
public final class ProvinceAverageDTO extends AbstractAverageDTO implements Serializable {

    private String provinceName;

    private String provinceShortName;

    private String countryName;

    private String countryShortName;

    public ProvinceAverageDTO() {
    }

    public ProvinceAverageDTO(String provinceName, String provinceShortName, String countryName, String countryShortName) {

        super();

        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.countryName = countryName;
        this.countryShortName = countryShortName;
    }

    public ProvinceAverageDTO(String provinceName, String provinceShortName, String countryName, String countryShortName,
                              Double staffAttitudeRating, Double cleanlinessRating, Double waitingTimesRating,
                              Double drugAvailabilityRating, Double infectionControlRating,
                              Double safeAndSecureCareRating, Long totalResponses) {

        super(staffAttitudeRating, cleanlinessRating, waitingTimesRating, drugAvailabilityRating,
                infectionControlRating, safeAndSecureCareRating, totalResponses);

        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.countryName = countryName;
        this.countryShortName = countryShortName;
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
