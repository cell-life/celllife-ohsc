package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 15h34
 */
public final class SubDistrictAverageDTO extends AbstractAverageDTO implements Serializable {

    public SubDistrictAverageDTO() {
    }

    public SubDistrictAverageDTO(String identifier, String name, String parentIdentifier, String parentName) {

        super(RegionType.SUB_DISTRICT, identifier, name, RegionType.DISTRICT, parentIdentifier, parentName);
    }

    public SubDistrictAverageDTO(String identifier, String name, String parentIdentifier, String parentName,
                                 Double staffAttitudeRating, Double cleanlinessRating, Double waitingTimesRating,
                                 Double drugAvailabilityRating, Double infectionControlRating,
                                 Double safeAndSecureCareRating, Long totalResponses) {

        super(RegionType.SUB_DISTRICT, identifier, name, RegionType.DISTRICT, parentIdentifier, parentName, staffAttitudeRating,
                cleanlinessRating, waitingTimesRating, drugAvailabilityRating, infectionControlRating,
                safeAndSecureCareRating, totalResponses);
    }
}
