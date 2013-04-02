package org.celllife.ohsc.domain.rating;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-02
 * Time: 13h21
 */
public class RatingTest {

    @Test
    public void testIsComplete() throws Exception {

        Rating rating = new Rating();
        ArrayList<Question> questions = new ArrayList<>();

        for (Domain domain : Domain.values()) {
            Question question = new Question();
            question.setDomainCode(domain.getCode());
            question.setAnswer(new Answer("Bla", 1));
            questions.add(question);
        }

        rating.setQuestions(questions);

        Assert.assertTrue(rating.isComplete());
    }

    @Test
    public void testIsNotComplete() throws Exception {

        Rating rating = new Rating();
        ArrayList<Question> questions = new ArrayList<>();

        for (Domain domain : Domain.values()) {

            if (domain == Domain.CLEANLINESS) {
                continue;
            }

            Question question = new Question();
            question.setDomainCode(domain.getCode());
            question.setAnswer(new Answer("Bla", 1));
            questions.add(question);
        }

        rating.setQuestions(questions);

        Assert.assertFalse(rating.isComplete());
    }
}
