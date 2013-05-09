package org.celllife.ohsc.application.rating;

import java.util.Date;

import org.celllife.ohsc.domain.datamart.ClinicIndividualRatingDTO;
import org.celllife.ohsc.domain.rating.Rating;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-02
 * Time: 11h14
 */
public interface RatingApplicationService {

    void save(Rating rating);
    
    /**
     * Retrieves a list of the individual ratings for a clinic
     * @param clinicCode String unique clinic code
     * @return
     */
    Iterable<ClinicIndividualRatingDTO> findIndividualRatingsByClinic(String clinicCode, Date startDate, Date endDate);

}
