package org.celllife.ohsc.domain.rating;

import javax.persistence.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 13h58
 */
@Embeddable
public class Answer {

    @Basic
    private String text;

    @Basic
    private Integer value;

    public Answer() {
    }

    public Answer(String text, Integer value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
