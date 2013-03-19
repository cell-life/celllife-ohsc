package org.celllife.ohsc.domain.clinic;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 20h09
 */
@Embeddable
public final class Group implements Serializable {

    @Basic
    private String name;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!name.equals(group.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
