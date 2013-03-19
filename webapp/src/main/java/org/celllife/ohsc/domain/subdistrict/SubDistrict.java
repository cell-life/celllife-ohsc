package org.celllife.ohsc.domain.subdistrict;

import org.celllife.ohsc.domain.district.District;

import javax.persistence.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 16h08
 */
@Entity
public class SubDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Basic
    private String externalId;

    @Basic
    private String name;

    @Basic
    private String shortName;

    @Lob
    private String coordinates;

    @OneToOne(fetch = FetchType.EAGER)
    private District district;

    public SubDistrict() {
    }

    public SubDistrict(String externalId, String name) {
        this.externalId = externalId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "SubDistrict{" +
                "shortName='" + shortName + '\'' +
                ", name='" + name + '\'' +
                ", externalId='" + externalId + '\'' +
                ", id=" + id +
                '}';
    }
}
