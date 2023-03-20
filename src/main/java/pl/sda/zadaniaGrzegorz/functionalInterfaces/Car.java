package pl.sda.zadaniaGrzegorz.functionalInterfaces;

public class Car {
    private String name;
    private String engine;

    public Car(String name, String engine) {
        System.out.println("Creating new car " + name + " with engine " + engine);
        this.name = name;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }
}
