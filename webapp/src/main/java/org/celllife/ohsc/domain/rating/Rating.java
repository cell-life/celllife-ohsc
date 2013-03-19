package org.celllife.ohsc.domain.rating;

import org.celllife.ohsc.domain.clinic.Clinic;
import org.celllife.ohsc.domain.language.Language;
import org.celllife.ohsc.domain.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 13h45
 */
@Entity
public final class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Questionnaire questionnaire;

    @OneToOne
    private Clinic clinic;

    @OneToOne
    private Language language;

    @JoinColumn(name = "rating")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Question> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }


    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language languageCode) {
        this.language = languageCode;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Integer getDomainRating(String domainCode) {

        for (Question question : questions) {
            if (question.getDomainCode().equals(domainCode)) {
                return question.getRatingValue();
            }
        }

        return null;
    }
}
