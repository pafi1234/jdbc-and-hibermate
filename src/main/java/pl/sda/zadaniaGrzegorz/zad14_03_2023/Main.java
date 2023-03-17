package pl.sda.zadaniaGrzegorz.zad14_03_2023;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
//    Założyć klasę reprezentującą człowieka, który ma imię, nazwisko, wiek, datę urodzenia, płeć, liczbę dzieci, listę dzieci
//    Każde dziecko też jest klasy “człowiek”
//    ------------
//    Weźcie pod uwagę że nie wszyscy ludzie będą mieć dzieci więc zakładanie obiektu raczej bez listy dzieci, te się dołoży później
//------------
//    Płeć - na pewno jako enum, najlepiej z polami “index”, “plTranslation”, “enTranslation”, “abbreviation”
//    W klasie człowieka dołożyć metodę zwracającą String podsumowujący dane osoby, z parametrem wejściowym boolean - jeśli true to pokazujemy ile ma dzieci, jeśli false to nie
//    Założyć kilka osób
//    Wypisać je na ekranie
//    Dołożyć możliwość sortowania po nazwisku - to ma być domyślny sposób sortowania
//    Wyświetlić osoby posortowane po nazwisku
//------------
//    Dołożyć możliwość sortowania po wieku od najstarszego i wyświetlić
//------------
//    Wyświetlić listę wszystkich dzieci
//------------
//    Wyświetlić sumę lat wszystkich ludzi (bez dzieci)
//------------
//    Wyciągnąć listę wszystkich dzieci do osobnej struktury (jakaś lista dzieci)
//------------
//    Listę dzieci i tą wcześniejszą listę ludzi połączyć do mapy gdzie kluczem będzie nazwisko a  wartością lista osób o danym nazwisku
//------------
//    Zapisać do pliku tekstowego wszystkich ludzi, każdy człowiek w osobnej linii, poszczególne pola oddzielone

    public static void main(String[] args) {

        var man1 = new Man("Beata", "Kopania", Gender.FEMALE, 32, LocalDate.of(1991, 03, 01), 0);
        var man2 = new Man("Monika", "Szlengel", Gender.FEMALE, 38, LocalDate.of(1985, 01, 03), 4);
        var man3 = new Man("Jakub", "Sieczko", Gender.MALE, 37, LocalDate.of(1985, 04, 25), 2);

        var man4 = new Man("Patrycja", "Figat", "f", 29, LocalDate.of(1993, 10, 29), 0);
        var man5 = new Man("Magdalena", "Komsa", "f", 29, LocalDate.of(1993, 12, 12), 4);
        var man6 = new Man("Antoni", "Sobala", "m", 43, LocalDate.of(1980, 01, 10), 0);

        man2.addChild(new Man("Mikołaj", "Szlengel", "m", 13, LocalDate.of(2010, 12, 01), 0));
        man2.addChild(new Man("Klaudia", "Szlengel", "f", 7, LocalDate.of(2016, 10, 1), 0));
        man2.addChild(new Man("Zuzia", "Szlengel", "f", 11, LocalDate.of(2012, 6, 1), 0));
        man2.addChild(new Man("Norbert", "Szlengel", "m", 9, LocalDate.of(2014, 4, 1), 0));

        man3.addChild(new Man("Kornel", "Sieczko", "m", 17, LocalDate.of(2006, 7, 1), 0));
        man3.addChild(new Man("Natalia", "Sieczko", "f", 5, LocalDate.of(2018, 8, 1), 0));

        man5.addChild(new Man("Eryk", "Komsa", "m", 17, LocalDate.of(2006, 7, 1), 0));
        man5.addChild(new Man("Ewa", "Komsa", "f", 5, LocalDate.of(2018, 9, 4), 0));
        man5.addChild(new Man("Karolina", "Komsa", "f", 3, LocalDate.of(2020, 6, 1), 0));
        man5.addChild(new Man("Michał", "Komsa", "m", 9, LocalDate.of(2014, 4, 19), 0));

        System.out.println("Lista osób: ");
        List<Man> people = List.of(man1, man2, man3, man4, man5, man6);
        people.forEach(each -> System.out.println(each.manInfo(false)));
        grubaKrecha();

        System.out.println("Lista osób posortowana po nazwisku: ");
        people.stream()
                .sorted()
                .forEach(each -> System.out.println(each.manInfo(true)));
        grubaKrecha();

        System.out.println("Lista osób posortowana po wieku malejąco: ");
        people.stream()
                .sorted(new ManByAgeComparator())
                .forEach(each -> System.out.println(each.manInfo(false)));
        grubaKrecha();

        System.out.println("Lista wszystkich dzieci: ");
        people.stream()
                //map czyli "przekształć element strumienia na "coś",
                //w tym przypadku przekształć Person na List<Person>
                // czyli na wejściu jest osoba a na wyjściu lista dzieci tej osoby
                //.map(each -> each.getChildren())
                .map(Man::getChildren)
                //flatMap czyli "spłaszcz i przekształć"
                //czyli wyciągamy "wnętrze" elementu strumienia
                //w naszym przypadku strumień list dzieci przekształcamy
                // na jeden wspólny strumień wszystkich dzieci
                .flatMap(Collection::stream)
                .forEach(each -> System.out.println(each.manInfo(false)));
        grubaKrecha();

        int ageSume = people.stream()
                .map(Man::getAge)
                .reduce(0, (current, incoming) -> current + incoming);
        System.out.println("Suma lat wszystkich ludzi to " + ageSume);
        grubaKrecha();

        System.out.println("Dzieci i dorośli do osobnej struktury: ");
        List<Man> allChildren = people.stream()
                //z każdego człowieka "wyciaga sie" dzieci
                .map(Man::getChildren)
                .flatMap(Collection::stream)
                //ze skrzynki osob np. Szlengel wyciaga sie ludzi
                //i ustawia w kolejnce. była kolejka skrzynek, teraz jest kolejka ludzi
                .collect(Collectors.toList());

        Map<String, List<Man>> peopleGroupByLastName = Stream.of(people, allChildren)
                .flatMap(Collection::stream)
                //z wszystkich elementów o wspolnym nazwisku zrobic liste
                //i w mapie dla danego nazwiska robi sie lista osob
                //jesli dla danego nazwiska jrdt tylko 1 osoba to i tak tworzy sie lista jednoelementowa
                .collect(Collectors.groupingBy(each -> each.getLastName(), Collectors.toList()));

        peopleGroupByLastName.entrySet()
                .stream()
                .forEach(each -> {
                    System.out.println("Klucz (nazwisko): " + each.getKey());
                    each.getValue().forEach(val -> System.out.println("\t" + val.manInfo(false)));
                });
        grubaKrecha();

        int someIntVal = 1;
        System.out.println("Drukuję intVal: " + someIntVal);
    }

    private static void grubaKrecha() {
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
    }
}
