package pl.sda.zadaniaGrzegorz.functionalInterfaces.consumer;

import pl.sda.zadaniaGrzegorz.functionalInterfaces.Car;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Car sportCar = new Car("Ford Mustang", "4.5");
        Car familyCar = new Car("Ford CMax", "1.6");

        /**
         * Interfejs Consumer
         *
         * przyjmuje obiekt
         * wykonuje operację
         * nic nie zwraca
         *
         * zapis (car) -> {...} mówi że do consumera printCarMark przekazujemy coś
         * i na tym "cosiu" wykonywana jest oprogramowana operacja
         *
         * Interfejs Consumer ma 1 metodę abstrakcyjną : metoda accept()
         */


        //!!!!!!!!!!!!!!!!!
        //Interfejs funkcyjny powstał po to żeby zmniejszyć ilość kodu pisanego przy wywoływaniu
        // klas anonimowych
        //!!!!!!!!!!!!!!!!!

        //Consumer<Car> printCarMark = new Consumer{ @Override void accept() { i tu println w środku }
        Consumer<Car> printCarMark = (car) -> {
            System.out.println("Printing car's mark:");
            System.out.println(car.getName().substring(0, car.getName().indexOf(" ")));
        };

        System.out.println("");
        printCarMark.accept(familyCar);
        System.out.println("");
        printCarMark.accept(sportCar);
    }
}
