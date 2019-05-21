package com.roma.hometestwork.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "officechairs")
public class OfficeChair extends Chair {

    @Column(name = "cloth")
    private String cloth;

    public String getCloth() {
        return cloth;
    }

    public void setCloth(String cloth) {
        this.cloth = cloth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficeChair that = (OfficeChair) o;
        return Objects.equals(cloth, that.cloth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cloth);
    }

    @Override
    public String toString() {
        return "OfficeChair{" +
                "cloth='" + cloth + '\'' +
                '}';
    }

    public interface Update {
        // empty interface
    }

    public interface Create {
        // empty interface
    }
}
