package pl.sda.zadaniaGrzegorz.hibernateDemo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * żeby klasa była oznaczona jako encja, czyli odwzorowanie tabeli w bazie danych,
 * to konieczne jest nalozenie dwoch konotacji:
 * @Entity - na klasę - klasa to encja
 * @Id - na pole, które traktuje się jako identyfikator
 *
 *
 * !!! Hibernate wymaga konstruktora bezparametrowego, więc jesli
 * w klasie jest inny konstruktor to trzeba utworzyć też bezparametrowy na potrzeby Hibernate
 *
 */
@Setter
@Getter
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String model;

}
