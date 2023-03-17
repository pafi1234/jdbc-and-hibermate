package pl.sda.zadaniaGrzegorz.zad14_03_2023;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Man implements Comparable<Man> {

    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private LocalDate birthDate;
    private int howMuchChildren;
    private List<Man> children;

    public Man(String firstName, String lastName, Gender gender, int age, LocalDate birthDate, int howMuchChildren) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.birthDate = birthDate;
        this.howMuchChildren = howMuchChildren;
        children = new ArrayList<>();
    }

    //tutaj płeć będzie wyszukiwana po skrócie, a w poprzednim konstruktorze po całym słowie
    public Man(String firstName, String lastName, String genderAbbrev, int age, LocalDate birthDate, int howMuchChildren) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = Gender.findByAbbrev(genderAbbrev);
        this.age = age;
        this.birthDate = birthDate;
        this.howMuchChildren = howMuchChildren;
        children = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Man> getChildren() {
        return children;
    }

    public void addChild(Man child) {
        children.add(child);
    }
    //wypisywanie informacji o liczbie dzieci
    public String manInfo(boolean showHowMuchChildren) {
        StringBuilder childrenInfo = showHowMuchChildren
                ? new StringBuilder(", dzieci = ").append(howMuchChildren)
                : new StringBuilder("");

        return new StringBuilder("Dane osoby: imię = ").append(firstName)
                .append(", nazwisko = ").append(lastName)
                .append(", wiek = ").append(age)
                .append(", data urodzenia = ").append(birthDate.toString())
                .append(childrenInfo)
                .toString();
    }


    @Override
    public int compareTo(Man other) {
        return this.lastName.compareTo(other.lastName);
    }
}
