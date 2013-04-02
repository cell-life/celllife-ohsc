package org.celllife.ohsc.application.rating;

import org.celllife.ohsc.domain.rating.Rating;
import org.celllife.ohsc.domain.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-17
 * Time: 10h31
 */
@Service
public class RatingApplicationServiceImpl implements RatingApplicationService {

    @Autowired
    private RatingRepository ratingRepository;

    public void save(Rating rating) {

        ratingRepository.save(rating);

    }
}


