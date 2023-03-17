package pl.sda.zadaniaGrzegorz.zad14_03_2023;

import java.util.Comparator;


public class ManByAgeComparator implements Comparator<Man> {
    @Override
    public int compare(Man first, Man second) {
        return second.getAge() - first.getAge();
    }
}