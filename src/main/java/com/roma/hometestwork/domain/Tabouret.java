package com.roma.hometestwork.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tabourets")
public class Tabouret extends Chair {

    @Column(name = "hight")
    private double hight;

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tabouret tabouret = (Tabouret) o;
        return Double.compare(tabouret.hight, hight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hight);
    }

    @Override
    public String toString() {
        return "Tabouret{" +
                "hight=" + hight +
                '}';
    }

    public interface Update {
        // empty interface
    }

    public interface Create {
        // empty interface
    }
}