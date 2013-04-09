package org.celllife.ohsc.domain.datamart;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-09
 * Time: 14h26
 */
public class ClinicAverageDTO extends AbstractAverageDTO {

    public ClinicAverageDTO() {
    }

    public ClinicAverageDTO(String identifier, String name, String parentName, String parentIdentifier) {

        super(RegionType.CLINIC, identifier, name, RegionType.SUB_DISTRICT, parentIdentifier, parentName);
    }

    public ClinicAverageDTO(String identifier, String name, String parentIdentifier, String parentName,
                            Double staffAttitudeRating, Double cleanlinessRating, Double waitingTimesRating,
                            Double drugAvailabilityRating, Double infectionControlRating, Double safeAndSecureCareRating,
                            Long totalResponses) {

        super(RegionType.CLINIC, identifier, name, RegionType.SUB_DISTRICT, parentIdentifier, parentName,
                staffAttitudeRating, cleanlinessRating, waitingTimesRating, drugAvailabilityRating,
                infectionControlRating, safeAndSecureCareRating, totalResponses);
    }
}
