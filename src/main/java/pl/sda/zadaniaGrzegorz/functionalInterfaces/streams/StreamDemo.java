package pl.sda.zadaniaGrzegorz.functionalInterfaces.streams;

import pl.sda.zadaniaGrzegorz.functionalInterfaces.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        class CarDTO{
            String nameConcat;
            public CarDTO(String nameConcat) {
                this.nameConcat = nameConcat;
            }

            public String getNameConcat() {
                return nameConcat;
            }
        }

        Car sportCar = new Car("Ford Mustang", "4.5");
        Car familyCar = new Car("Ford CMax", "1.6");
        Car vanCar = new Car("Ford Transit", "2.5");
        Car volvoCar = new Car("Volvo V50", "1.8");
        Car fiatCar = new Car("Fiat Tico", "1.1");

        List<Car> carList= List.of(sportCar, familyCar, vanCar, volvoCar, fiatCar);

        grubaKrecha();
        System.out.println("Pierwsze dwa Fordy");
        carList.stream()
                .filter(x -> x.getName().startsWith("Ford"))
                .limit(2)
                .forEach(StreamDemo::printCarInfo);

        grubaKrecha();
        System.out.println("Kolejność ma znaczenie");
        carList.stream()
                .limit(2)
                //filter zadziała tylko na 2 elementach także może się okazać że potem nie będzie już nic,
                //albo, jak w naszym przypadku, 1 element
                .filter(x -> x.getEngine().compareTo("4.0") > 0)
                .forEach(StreamDemo::printCarInfo);

        /**
         * Generalnie operacje na strumieniach dzielą się na 3 grupy:
         * - tworzące (metoda stream(), metoda Arrays.stream(tabela), metoda of, i pewnie jeszcze kilka
         * - pośrednie - limit, filter, sorted, map, flatMap, peek, ...
         * - kończące - forEach, reduce, collect, sum, max, min, findFirst, findAny, ...
         */

        grubaKrecha();
        //przekształcenie listy obiektów w listę innych obiektów
        List<CarDTO> carDTOS = carList.stream()
                .map(x -> new CarDTO(x.getName() + " " + x.getEngine()))
                .collect(Collectors.toList());

        System.out.println("Lista carDTOS zawiera " + carDTOS.size() + " pozycji");
        carDTOS.forEach(dto -> System.out.println("DTO: " + dto.getNameConcat()));

        Set<Car> carSet = new HashSet<>();
        carSet.add(new Car("Skoda Octavia", "2.0"));
        carSet.add(new Car("Skoda Fabia", "1.1"));
        carSet.add(new Car("Skoda Kodiaq", "2.5"));

        grubaKrecha();
        List<Car> commonList = Stream.of(carList, carSet) // tu mamy strumień 2-elementowy z listy i seta
                //flatmap mówi żeby to spłaszczyć
                //czyli z każdej z powyższych kolekcji
                //wyciągnąć elementy i potem działać na tych elementach
                .flatMap(coll -> coll.stream())
                .collect(Collectors.toList());
        System.out.println("Drukujemy wspólną listę:");
        commonList.forEach(StreamDemo::printCarInfo);

        grubaKrecha();
        System.out.println("Drukujemy listę samochodów jako 1 napis");
        String joined = commonList.stream()
                .map(Car::getName)
                .collect(Collectors.joining());
        System.out.println(joined);
        System.out.println("z przecinkami");
        String joinedWithCommas = commonList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(joinedWithCommas);
        System.out.println("z przecinkami");
        String joinedWithCommasAndBrackets = commonList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joinedWithCommasAndBrackets);

        grubaKrecha();

        System.out.println("Kolejna mapa z listy");
        Map<String, Car> carsByName = commonList.stream()
                .collect(Collectors.toMap(x -> x.getName(), x -> x));


        commonList.add(new Car("Ford Mustang", "2.3"));
        commonList.add(new Car("Skoda Octavia", "1.4"));
        System.out.println("A teraz z listy zrobimy mapę ");
        Map<String, List<Car>> mapOfCarListsByBrand = commonList.stream()
                .collect(Collectors.groupingBy(Car::getName, Collectors.toList()));



        System.out.println("stop point");
    }

    private static void grubaKrecha() {
        System.out.println("\n===================================");
        System.out.println("==========GRUBA KRECHA=============");
        System.out.println("===================================\n");
    }

    private static void printCarInfo(Car car) {
        System.out.println(car.getName() + " " + car.getEngine());
    }
}
