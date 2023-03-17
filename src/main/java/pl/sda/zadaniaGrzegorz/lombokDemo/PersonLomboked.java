package pl.sda.zadaniaGrzegorz.lombokDemo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PersonLomboked {
    private String firstName;
    private String lastName;
    private int age;
}
