package org.celllife.ohsc.domain.rating;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-02
 * Time: 11h29
 */
public enum Domain {

    STAFF_ATTITUDE("1", "Staff Attitude"),
    CLEANLINESS("2", "Cleanliness"),
    WAITING_TIMES("3", "Waiting Times"),
    DRUG_AVAILABILITY("4", "Drug Availability"),
    INFECTION_CONTROL("5", "Infection Control"),
    SAFE_AND_SECURE_CARE("6", "Safe And Secure Care");

    private String code;
    private String name;

    Domain(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Domain findDomainByCode(String code) {

        for (Domain domain : values()) {

            if (domain.getCode().equals(code)) {
                return domain;
            }
        }

        return null;
    }
}
