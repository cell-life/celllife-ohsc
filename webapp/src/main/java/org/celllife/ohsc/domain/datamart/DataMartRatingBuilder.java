package org.celllife.ohsc.domain.datamart;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-02
 * Time: 11h20
 */
public final class DataMartRatingBuilder {

    private final DataMartRating dataMartRating;

    public DataMartRatingBuilder() {

        this.dataMartRating = new DataMartRating();
    }

    public DataMartRatingBuilder setUssdSessionId(String ussdSessionId) {

        dataMartRating.setUssdSessionId(ussdSessionId);
        return this;
    }

    public DataMartRatingBuilder setClinicCode(String clinicCode) {

        dataMartRating.setClinicCode(clinicCode);
        return this;
    }

    public DataMartRatingBuilder setClinicShortName(String clinicShortName) {

        dataMartRating.setClinicShortName(clinicShortName);
        return this;
    }

    public DataMartRatingBuilder setSubDistrictName(String subDistrictName) {

        dataMartRating.setSubDistrictName(subDistrictName);
        return this;
    }

    public DataMartRatingBuilder setSubDistrictShortName(String subDistrictShortName) {

        dataMartRating.setSubDistrictShortName(subDistrictShortName);
        return this;
    }

    public DataMartRatingBuilder setDistrictName(String districtName) {

        dataMartRating.setDistrictName(districtName);
        return this;
    }

    public DataMartRatingBuilder setDistrictShortName(String districtShortName) {

        dataMartRating.setDistrictShortName(districtShortName);
        return this;
    }

    public DataMartRatingBuilder setProvinceName(String provinceName) {

        dataMartRating.setProvinceName(provinceName);
        return this;
    }

    public DataMartRatingBuilder setProvinceShortName(String provinceShortName) {

        dataMartRating.setProvinceShortName(provinceShortName);
        return this;
    }

    public DataMartRatingBuilder setCountryName(String countryName) {

        dataMartRating.setCountryName(countryName);
        return this;
    }

    public DataMartRatingBuilder setCountryShortName(String countryShortName) {

        dataMartRating.setCountryShortName(countryShortName);
        return this;
    }

    public DataMartRatingBuilder setStaffAttitudeRating(Double staffAttitudeRating) {

        dataMartRating.setStaffAttitudeRating(staffAttitudeRating);
        return this;
    }

    public DataMartRatingBuilder setCleanlinessRating(Double cleanlinessRating) {

        dataMartRating.setCleanlinessRating(cleanlinessRating);
        return this;
    }

    public DataMartRatingBuilder setWaitingTimesRating(Double waitingTimesRating) {

        dataMartRating.setWaitingTimesRating(waitingTimesRating);
        return this;
    }

    public DataMartRatingBuilder setDrugAvailabilityRating(Double drugAvailabilityRating) {

        dataMartRating.setDrugAvailabilityRating(drugAvailabilityRating);
        return this;
    }

    public DataMartRatingBuilder setInfectionControlRating(Double infectionControlRating) {

        dataMartRating.setInfectionControlRating(infectionControlRating);
        return this;
    }

    public DataMartRatingBuilder setSafeAndSecureCareRating(Double safeAndSecureCareRating) {

        dataMartRating.setSafeAndSecureCareRating(safeAndSecureCareRating);
        return this;
    }

    public DataMartRating getDataMartRating() {

        return dataMartRating;
    }
}
