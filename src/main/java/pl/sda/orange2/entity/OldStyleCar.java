package pl.sda.orange2.entity;

import java.util.Objects;

public class OldStyleCar {
    private final Long id;
    private final String colour;
    private final String brand;
    private final String model;

    public OldStyleCar(Long id, String colour, String brand, String model) {
        this.id = id;
        this.colour = colour;
        this.brand = brand;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public String getColour() {
        return colour;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", colour='" + colour + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldStyleCar car = (OldStyleCar) o;
        return getId().equals(car.getId()) && getColour().equals(car.getColour()) && getBrand().equals(car.getBrand()) && getModel().equals(car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getColour(), getBrand(), getModel());
    }
}
