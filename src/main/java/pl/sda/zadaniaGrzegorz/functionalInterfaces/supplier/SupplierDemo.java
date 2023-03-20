package pl.sda.zadaniaGrzegorz.functionalInterfaces.supplier;

import pl.sda.zadaniaGrzegorz.functionalInterfaces.Car;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        Car familyVan = new Car("VW Transporter", "2.5");
        /**
         * Supplier
         * Nie przyjmuje żadnego parametru ale zwraca obiekt
         *
         * Wykonuje czynność zdefiniowaną dopiero w momencie wywołania,
         * czyli jeśli jest to potrzebne
         *
         * zapis () -> new Car(...) to definicja ale nie wywołanie
         */

        Supplier<Car> sportCar = () -> new Car("Ford Mustang", "4.5");
        Supplier<Car> familyCar = () -> new Car("Ford CMax", "1.6");

        System.out.println(getCarInfo(sportCar));
        System.out.println(getCarInfo(familyCar));

        /**
         * Jak mamy obiekt a funkcja wymaga podania suppliera to z obiektu robimy supplier
         * tak jak w kodzie poniżej
         */

        //System.out.println(getCarInfo(familyVan)); to nie zadziała bo przekazujemy obiekt a konieczny jest supplier
        System.out.println("\nSupplier z przekazanego obiektu:");
        System.out.println(getCarInfo(() -> familyVan));

    }

    public static String getCarInfo(Supplier<Car> supplier) {
        Car passedCar = supplier.get();

        return new StringBuilder(passedCar.getName())
                .append(" ")
                .append(passedCar.getEngine())
                .toString();
    }
}
