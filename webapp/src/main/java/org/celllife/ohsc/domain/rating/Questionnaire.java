package org.celllife.ohsc.domain.rating;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 13h46
 */
@Embeddable
public class Questionnaire implements Serializable {

    @Basic
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
