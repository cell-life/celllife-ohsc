package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 15h34
 */
public final class ProvinceAverageDTO extends AbstractAverageDTO implements Serializable {

    public ProvinceAverageDTO() {
    }

    public ProvinceAverageDTO(String identifier, String name) {

        super(RegionType.PROVINCE, identifier, name, RegionType.COUNTRY, "za South Africa", "South Africa");
    }

    public ProvinceAverageDTO(String identifier, String name, Double staffAttitudeRating,
                              Double cleanlinessRating, Double waitingTimesRating, Double drugAvailabilityRating,
                              Double infectionControlRating, Double safeAndSecureCareRating, Long totalResponses) {

        super(RegionType.PROVINCE, identifier, name, RegionType.COUNTRY, "za South Africa", "South Africa",
                staffAttitudeRating, cleanlinessRating, waitingTimesRating, drugAvailabilityRating,
                infectionControlRating, safeAndSecureCareRating, totalResponses);
    }

}
