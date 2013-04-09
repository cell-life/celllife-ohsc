package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 15h34
 */
public abstract class AbstractAverageDTO implements Serializable {

    private RegionType regionType;

    private String identifier;

    private String name;

    private RegionType parentRegionType;

    private String parentIdentifier;

    private String parentName;

    private Double staffAttitudeRating;

    private Double cleanlinessRating;

    private Double waitingTimesRating;

    private Double drugAvailabilityRating;

    private Double infectionControlRating;

    private Double safeAndSecureCareRating;

    private Long totalResponses;

    public AbstractAverageDTO() {
    }

    public AbstractAverageDTO(RegionType regionType, String identifier, String name,
                              RegionType parentRegionType, String parentIdentifier, String parentName) {

        this.regionType = regionType;
        this.identifier = identifier;
        this.name = name;
        this.parentRegionType = parentRegionType;
        this.parentIdentifier = parentIdentifier;
        this.parentName = parentName;
    }

    public AbstractAverageDTO(RegionType regionType, String identifier, String name, Double staffAttitudeRating,
                              Double cleanlinessRating, Double waitingTimesRating, Double drugAvailabilityRating,
                              Double infectionControlRating, Double safeAndSecureCareRating, Long totalResponses) {

        this.regionType = regionType;
        this.identifier = identifier;
        this.name = name;
        this.staffAttitudeRating = staffAttitudeRating;
        this.cleanlinessRating = cleanlinessRating;
        this.waitingTimesRating = waitingTimesRating;
        this.drugAvailabilityRating = drugAvailabilityRating;
        this.infectionControlRating = infectionControlRating;
        this.safeAndSecureCareRating = safeAndSecureCareRating;
        this.totalResponses = totalResponses;
    }

    public AbstractAverageDTO(RegionType regionType, String identifier, String name, RegionType parentRegionType,
                              String parentIdentifier, String parentName, Double staffAttitudeRating, Double cleanlinessRating,
                              Double waitingTimesRating, Double drugAvailabilityRating, Double infectionControlRating,
                              Double safeAndSecureCareRating, Long totalResponses) {

        this.regionType = regionType;
        this.identifier = identifier;
        this.name = name;
        this.parentRegionType = parentRegionType;
        this.parentIdentifier = parentIdentifier;
        this.parentName = parentName;
        this.staffAttitudeRating = staffAttitudeRating;
        this.cleanlinessRating = cleanlinessRating;
        this.waitingTimesRating = waitingTimesRating;
        this.drugAvailabilityRating = drugAvailabilityRating;
        this.infectionControlRating = infectionControlRating;
        this.safeAndSecureCareRating = safeAndSecureCareRating;
        this.totalResponses = totalResponses;
    }

    public RegionType getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionType regionType) {
        this.regionType = regionType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegionType getParentRegionType() {
        return parentRegionType;
    }

    public void setParentRegionType(RegionType parentRegionType) {
        this.parentRegionType = parentRegionType;
    }

    public String getParentIdentifier() {
        return parentIdentifier;
    }

    public void setParentIdentifier(String parentIdentifier) {
        this.parentIdentifier = parentIdentifier;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
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
}
