package org.celllife.ohsc.domain.user;

import org.celllife.ohsc.domain.mno.MobileNetworkOperator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-17
 * Time: 13h44
 */
@Entity
public final class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Basic
    private String msisdn;

    @OneToOne
    private MobileNetworkOperator mobileNetworkOperator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public MobileNetworkOperator getMobileNetworkOperator() {
        return mobileNetworkOperator;
    }

    public void setMobileNetworkOperator(MobileNetworkOperator mobileNetworkOperator) {
        this.mobileNetworkOperator = mobileNetworkOperator;
    }

    @Override
    public String toString() {
        return "User{" +
                "msisdn='" + msisdn + '\'' +
                ", id=" + id +
                '}';
    }
}
