package org.celllife.ohsc.domain.rating;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-17
 * Time: 13h44
 */
@Embeddable
public final class User implements Serializable {

    @Basic
    private String msisdn;

    @Basic
    private String mnoCode;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMnoCode() {
        return mnoCode;
    }

    public void setMnoCode(String mnoCode) {
        this.mnoCode = mnoCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "msisdn='" + msisdn + '\'' +
                '}';
    }
}
