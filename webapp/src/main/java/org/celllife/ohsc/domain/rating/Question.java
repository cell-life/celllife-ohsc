package org.celllife.ohsc.domain.rating;

import javax.persistence.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 13h57
 */
@Embeddable
public class Question {

    private String domainCode;

    private String text;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "text", column = @Column(name = "answerText")),
            @AttributeOverride(name = "value", column = @Column(name = "answerValue", columnDefinition = "BIGINT"))
    })
    private Answer answer;

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
