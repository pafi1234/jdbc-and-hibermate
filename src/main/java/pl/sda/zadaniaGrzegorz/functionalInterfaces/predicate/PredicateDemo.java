package pl.sda.zadaniaGrzegorz.functionalInterfaces.predicate;

import pl.sda.zadaniaGrzegorz.functionalInterfaces.Car;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Car sportCar = new Car("Ford Mustang", "4.5");
        Car familyCar = new Car("Ford CMax", "1.6");
        Car vanCar = new Car("Ford Transit", "2.5");
        Car volvoCar = new Car("Volvo V50", "1.8");

        /**
         * Predicate czyli test
         * Definiuje warunek do sprawdzenia na przekazanym obiekcie
         * Jako parametr wejściowy przyjmuje obiekt, zwraca boolean
         *
         * Predicate<Car> (x) -> ... definiuje warunek do sprawdzenia
         * ten warunek to implementacja metody test interfejsu Predicate
         */

        Predicate<Car> isSmallEngine = (x) -> x.getEngine().compareTo("2.0") < 0;
        Predicate<Car> isVolvo = (x) -> {
            System.out.println("Testing if it's Volvo");
            return x.getName().startsWith("Volvo");
        };

        System.out.println("\n========================\n");
        printCarIfPossible(familyCar, isSmallEngine);
        printCarIfPossible(sportCar, isSmallEngine);
        printCarIfPossible(vanCar, isVolvo);
        printCarIfPossible(volvoCar, isSmallEngine);
        printCarIfPossible(volvoCar, isVolvo);

        if (isSmallEngine.test(familyCar)) {
            System.out.println("\ncheck if family car is small engine");
            System.out.println(familyCar.getName());
        }

    }

    private static void printCarIfPossible(Car car, Predicate<Car> predicate) {
        if(predicate.test(car)) {
            System.out.println("Test passed for " + car.getName() + " " + car.getEngine());
        }
    }
}
