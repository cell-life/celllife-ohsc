package org.celllife.ohsc.domain.datamart;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-11
 * Time: 14h21
 */
public abstract class AbstractAverageDTO {

    private Double staffAttitudeRating;

    private Double cleanlinessRating;

    private Double waitingTimesRating;

    private Double drugAvailabilityRating;

    private Double infectionControlRating;

    private Double safeAndSecureCareRating;

    private Long totalResponses;

    protected AbstractAverageDTO() {
    }

    protected AbstractAverageDTO(Double staffAttitudeRating, Double cleanlinessRating, Double waitingTimesRating,
                              Double drugAvailabilityRating, Double infectionControlRating,
                              Double safeAndSecureCareRating, Long totalResponses) {

        this.staffAttitudeRating = staffAttitudeRating;
        this.cleanlinessRating = cleanlinessRating;
        this.waitingTimesRating = waitingTimesRating;
        this.drugAvailabilityRating = drugAvailabilityRating;
        this.infectionControlRating = infectionControlRating;
        this.safeAndSecureCareRating = safeAndSecureCareRating;
        this.totalResponses = totalResponses;
    }

    public Double getStaffAttitudeRating() {
        return staffAttitudeRating;
    }

    public void setStaffAttitudeRating(Double staffAttitudeRating) {
        this.staffAttitudeRating = staffAttitudeRating;
    }

    public Double getCleanlinessRating() {
        return cleanlinessRating;
    }

    public void setCleanlinessRating(Double cleanlinessRating) {
        this.cleanlinessRating = cleanlinessRating;
    }

    public Double getWaitingTimesRating() {
        return waitingTimesRating;
    }

    public void setWaitingTimesRating(Double waitingTimesRating) {
        this.waitingTimesRating = waitingTimesRating;
    }

    public Double getDrugAvailabilityRating() {
        return drugAvailabilityRating;
    }

    public void setDrugAvailabilityRating(Double drugAvailabilityRating) {
        this.drugAvailabilityRating = drugAvailabilityRating;
    }

    public Double getInfectionControlRating() {
        return infectionControlRating;
    }

    public void setInfectionControlRating(Double infectionControlRating) {
        this.infectionControlRating = infectionControlRating;
    }

    public Double getSafeAndSecureCareRating() {
        return safeAndSecureCareRating;
    }

    public void setSafeAndSecureCareRating(Double safeAndSecureCareRating) {
        this.safeAndSecureCareRating = safeAndSecureCareRating;
    }

    public Long getTotalResponses() {
        return totalResponses;
    }

    public void setTotalResponses(Long totalResponses) {
        this.totalResponses = totalResponses;
    }

    public Double getAverageRating() {

        if (staffAttitudeRating == null || cleanlinessRating == null || waitingTimesRating == null ||
                drugAvailabilityRating == null || infectionControlRating == null || safeAndSecureCareRating == null) {

           return null;
        }

        return (staffAttitudeRating + cleanlinessRating + waitingTimesRating + drugAvailabilityRating +
                infectionControlRating + safeAndSecureCareRating) / 6.0D;
    }
}
