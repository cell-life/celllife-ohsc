package org.celllife.ohsc.domain.datamart;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-09
 * Time: 13h36
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RegionType {

    CLINIC("Clinic", "Clinics"),
    SUB_DISTRICT("SubDistrict", "SubDistricts"),
    DISTRICT("District", "Districts"),
    PROVINCE("Province", "Provinces"),
    COUNTRY("Country", "Countries");

    private String singular;

    private String plural;

    RegionType(String singular, String plural) {

        this.singular = singular;
        this.plural = plural;
    }

    public String getSingular() {
        return singular;
    }

    public String getPlural() {
        return plural;
    }
}
