package pl.sda.zadaniaGrzegorz.functionalInterfaces.optional;

import pl.sda.zadaniaGrzegorz.functionalInterfaces.Car;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        Car sportCar = new Car("Ford Mustang", "4.5");
        Car familyCar = new Car("Ford CMax", "1.6");
        Car vanCar = new Car("Ford Transit", "2.5");
        Car volvoCar = new Car("Volvo V50", "1.8");
        Car fiatCar = new Car("Fiat Tico", "1.1");
        Car nullCar = null;

        /**
         * Optional to kontener (pojemnik) na obiekt
         * Może mieć zawartość ale nie musi
         * Możemy sprawdzić czy ten kontener coś przechowuje i wtedy wykonać jakąś akcję
         */

        //pust pojemnik na obisekt
        Optional<Car> optionalEmptyCar = Optional.empty();

        //deklarowanie optionala z niepustym obiektem w środku
        Optional<Car> optionalNotEmptyCar = Optional.of(sportCar);
        //Optional<Car> forbiddenNullCar = Optional.of(nullCar); // to nam się wywali NPE

        //deklarowanie optionala z być może pustym obiektem w środku
        Optional<Car> maybeNullCar = Optional.ofNullable(nullCar);
        Optional<Car> possiblyNullCar = Optional.ofNullable(vanCar);

        /**
         * To teraz po co nam to
         */

        //Miliardy linii kodu wyglądają tak:
        if(optionalEmptyCar != null) {
            System.out.println("Jak nie jest nullem to cośtam");
            System.out.println("To działa ale null to ZŁO");
            System.out.println("To działa ale null to RAK");
        }

        //od Javy8 raczej robimy to tak
        if(possiblyNullCar.isPresent()) {
            System.out.println("W pojemniku jest : " + possiblyNullCar.get().getName());
            Car retrivedFromOptional = possiblyNullCar.get();
            System.out.println(retrivedFromOptional.getName() + " " + retrivedFromOptional.getEngine());
        }

        List<Car> cars = List.of(sportCar, familyCar, vanCar, volvoCar, fiatCar); //, nullCar);

        System.out.println("Szukamy pierwszego samochodu z silnikiem większym niż 4.0");
        Optional<Car> carWithBigEngine = cars.stream()
                .filter(x -> x.getEngine().compareTo("4.0") > 0)
                .findFirst();

        if(carWithBigEngine.isPresent()) {
            System.out.println("Jest czym docisnąć: " + carWithBigEngine.get().getName());
        }

        Car fiat =  cars.stream()
                .filter(x -> x.getName().startsWith("Fiat"))
                .peek(x -> System.out.println("\nPeeking if found: " + x.getName() + " " + x.getEngine()+ "\n"))
                .findAny()
                .orElse(new Car("Fiat Bravo", "1.4"));

        System.out.println("Fiat z streama:");
        System.out.println(fiat.getName() + " " + fiat.getEngine());


        //powyższy stream w postaci imperatywnej (ify i fory)
        Car fiat2 = null;
        for (Car car : cars) {
            if(car.getName().startsWith("Fiat")) {
                System.out.println("Again peeking if found " + car.getName() + " " + car.getEngine() + "\n");
                fiat2 = car;
                break;
            }
        }
        if(fiat2 == null) {
            fiat2 = new Car("Fiat Bravo", "1.4");
        }

        System.out.println("Fiat z ifologii z forologią:");
        System.out.println(fiat2.getName() + " " + fiat2.getEngine());


        Car volvo = cars.stream()
                .filter(x -> x.getName().startsWith("Volvo"))
                .findFirst()
                .orElseGet(() -> new Car("Volvo XC90", "3.2"));

        System.out.println("\nVolvo ze streama:");
        System.out.println(volvo.getName() + " " + volvo.getEngine());
    }
}
