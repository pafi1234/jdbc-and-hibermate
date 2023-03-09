package pl.sda.orange2.entity;

import java.util.Objects;

public class OldStyleCar {
    private final Long id;
    private final String colour;
    private final String brand;
    private final String model;

    public Long getId() {
        return id;
    }

    public OldStyleCar(Long id, String colour, String brand, String model) {
        this.id = id;
        this.colour = colour;
        this.brand = brand;
        this.model = model;
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
        OldStyleCar oldStyleCar = (OldStyleCar) o;
        return Objects.equals(id, oldStyleCar.id) && Objects.equals(colour, oldStyleCar.colour) && Objects.equals(brand, oldStyleCar.brand) && Objects.equals(model, oldStyleCar.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, colour, brand, model);
    }
}