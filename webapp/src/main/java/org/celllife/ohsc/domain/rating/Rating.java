package org.celllife.ohsc.domain.rating;

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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "msisdn", column = @Column(name = "userMsisdn")),
            @AttributeOverride(name = "mnoCode", column = @Column(name = "userMnoCode"))
    })
    private User user;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "version", column = @Column(name = "questionnaireVersion"))
    })
    private Questionnaire questionnaire;

    private String clinicCode;

    private String languageCode;

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

    public String getClinicCode() {
        return clinicCode;
    }

    public void setClinicCode(String clinic) {
        this.clinicCode = clinicCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
