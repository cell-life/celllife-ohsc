package org.celllife.ohsc.domain.ratingdatamart;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-02
 * Time: 11h20
 */
public final class RatingDataMartBuilder {

    private final RatingDataMart ratingDataMart;

    public RatingDataMartBuilder() {
        this.ratingDataMart = new RatingDataMart();
    }

    public RatingDataMartBuilder setUssdSessionId(String ussdSessionId) {

        ratingDataMart.setUssdSessionId(ussdSessionId);

        return this;
    }

    public RatingDataMartBuilder setClinic(String clinic) {

        ratingDataMart.setClinic(clinic);

        return this;
    }

    public RatingDataMartBuilder setSubDistrict(String subDistrict) {

        ratingDataMart.setSubDistrict(subDistrict);

        return this;
    }

    public RatingDataMartBuilder setDistrict(String district) {

        ratingDataMart.setDistrict(district);

        return this;
    }

    public RatingDataMartBuilder setProvince(String province) {

        ratingDataMart.setProvince(province);

        return this;
    }

    public RatingDataMartBuilder setStaffAttitudeRating(Double staffAttitudeRating) {

        ratingDataMart.setStaffAttitudeRating(staffAttitudeRating);

        return this;
    }

    public RatingDataMartBuilder setCleanlinessRating(Double cleanlinessRating) {

        ratingDataMart.setCleanlinessRating(cleanlinessRating);

        return this;
    }

    public RatingDataMartBuilder setWaitingTimesRating(Double waitingTimesRating) {

        ratingDataMart.setWaitingTimesRating(waitingTimesRating);

        return this;
    }

    public RatingDataMartBuilder setDrugAvailabilityRating(Double drugAvailabilityRating) {

        ratingDataMart.setDrugAvailabilityRating(drugAvailabilityRating);

        return this;
    }

    public RatingDataMartBuilder setInfectionControlRating(Double infectionControlRating) {

        ratingDataMart.setInfectionControlRating(infectionControlRating);

        return this;
    }

    public RatingDataMartBuilder setSafeAndSecureCareRating(Double safeAndSecureCareRating) {

        ratingDataMart.setSafeAndSecureCareRating(safeAndSecureCareRating);

        return this;
    }
    
    public RatingDataMart getRatingDataMart() {

        return ratingDataMart;
    }
}
