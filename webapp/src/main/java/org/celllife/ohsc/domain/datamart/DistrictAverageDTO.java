package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 15h34
 */
public final class DistrictAverageDTO extends AbstractAverageDTO implements Serializable {

    public DistrictAverageDTO() {
    }

    public DistrictAverageDTO(String identifier, String name, String parentIdentifier, String parentName) {

        super(RegionType.DISTRICT, identifier, name, RegionType.PROVINCE, parentIdentifier, parentName);
    }

    public DistrictAverageDTO(String identifier, String name, String parentIdentifier, String parentName,
                              Double staffAttitudeRating, Double cleanlinessRating, Double waitingTimesRating,
                              Double drugAvailabilityRating, Double infectionControlRating,
                              Double safeAndSecureCareRating, Long totalResponses) {

        super(RegionType.DISTRICT, identifier, name, RegionType.PROVINCE, parentIdentifier, parentName,
                staffAttitudeRating, cleanlinessRating, waitingTimesRating, drugAvailabilityRating,
                infectionControlRating, safeAndSecureCareRating, totalResponses);
    }
}
