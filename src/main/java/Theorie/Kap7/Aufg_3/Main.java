package Theorie.Kap7.Aufg_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Theorie.Kap7.Aufg_3.Person.Geschlecht;

public class Main {
    public static void main(String[] args) {

        List<Person> personen = new ArrayList<>(Arrays.asList(
                new Person("Anna", 12, Geschlecht.W),
                new Person("Hans", 15, Geschlecht.M),
                new Person("Anja", 27, Geschlecht.W),
                new Person("Kickl", 46, Geschlecht.D),
                new Person("Jakob", 19, Geschlecht.M),
                new Person("Patrick", 9, Geschlecht.M),
                new Person("Hannah", 17, Geschlecht.W)
        ));

        personen
                .stream()
                .sorted((p, b) -> b.getAlter() - p.getAlter()) // oder mit new Comparator {*implementation*}
                .forEach(System.out::println);

        System.out.println();

        double avg = personen
                .stream()
                .filter(p -> p.getGeschlecht() == Person.Geschlecht.M)
                .mapToInt(Person::getAlter)
                .average()
                .orElse(0.0);

        System.out.println(avg);
    }
}
