package com.roma.hometestwork.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chairs")
@Inheritance(strategy = InheritanceType.JOINED)
public class Chair {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "modelNumber")
    private Long modelNumber;
    @Column(name = "material")
    private String material;
    @Column(name = "price")
    private double price;

    public Chair() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(Long modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chair chair = (Chair) o;
        return Objects.equals(id, chair.id) &&
                Objects.equals(modelNumber, chair.modelNumber) &&
                Objects.equals(material, chair.material) &&
                Objects.equals(price, chair.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelNumber, material, price);
    }

    @Override
    public String toString() {
        return "Chair{" +
                "id=" + id +
                ", modelNumber=" + modelNumber +
                ", material='" + material + '\'' +
                ", price=" + price +
                '}';
    }

    public interface Update {
        // empty interface
    }

    public interface Create {
        // empty interface
    }
}