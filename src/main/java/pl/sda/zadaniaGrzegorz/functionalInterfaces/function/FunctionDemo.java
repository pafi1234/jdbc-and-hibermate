package pl.sda.zadaniaGrzegorz.functionalInterfaces.function;

import pl.sda.zadaniaGrzegorz.functionalInterfaces.Car;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        Car sportCar = new Car("Ford Mustang", "4.5");
        Car familyCar = new Car("Ford CMax", "1.6");
        Car vanCar = new Car("Ford Transit", "2.5");
        Car volvoCar = new Car("Volvo V50", "1.8");
        Car fiatCar = new Car("Volvo Tico", "1.1");

        /**
         * Interfejs Function
         * przyjmuje obiekt i zwraca obiekt
         * czyli może wykonać jakieś przekształcenie obiektu w nowy
         * albo wykonać na przekazanym jakieś działanie
         *
         * W interfejsie Function definiujemy metodę apply()
         */

        Function<Car, String> retriveEngine = (a) -> a.getEngine();

        Function<Car, Integer> calculateCarRating = x -> {
            if(x.getName().startsWith("Ford")) {
                return 10;
            }
            if(x.getName().startsWith("Volvo")) {
                return  8;
            }
            return 4;
        };

        Function<Car, String> dumbFunction = (car) -> "Always return same string, weird";

        System.out.println(dumbFunction.apply(vanCar));
        System.out.println(dumbFunction.apply(sportCar));
        System.out.println("");
        System.out.println("Engine");
        System.out.println(retriveEngine.apply(familyCar));
        System.out.println("");
        System.out.println("Ranking");
        System.out.println(calculateCarRating.apply(sportCar));
    }

}
