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

    public DataMartRatingBuilder setClinic(String clinic) {

        dataMartRating.setClinic(clinic);

        return this;
    }

    public DataMartRatingBuilder setSubDistrict(String subDistrict) {

        dataMartRating.setSubDistrict(subDistrict);

        return this;
    }

    public DataMartRatingBuilder setDistrict(String district) {

        dataMartRating.setDistrict(district);

        return this;
    }

    public DataMartRatingBuilder setProvince(String province) {

        dataMartRating.setProvince(province);

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
