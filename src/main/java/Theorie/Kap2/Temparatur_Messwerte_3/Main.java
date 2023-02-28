package Theorie.Kap2.Temparatur_Messwerte_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);
        int input;
        TemparaturMesswerte daten = new TemparaturMesswerte();

        while (true) {
            System.out.println("Messwert hinzufügen: Buchstabe für Stopp");
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                break;
            }
            daten.messWerte.add(input);
        }
        System.out.println("MIN: " + daten.min());
        System.out.println("MAX: " + daten.max());
        System.out.println("DURCHSCHNITT: " + daten.durchSchnitt());
    }

    static class TemparaturMesswerte {
        protected final List<Integer> messWerte = new ArrayList<>();

        public int max() {
            return this.messWerte.stream().reduce(Integer.MIN_VALUE, Math::max);
        }

        public int min() {
            return this.messWerte.stream().reduce(Integer.MAX_VALUE, Math::min);
        }

        public double durchSchnitt() {
            return this.messWerte.stream().mapToInt(messWert -> messWert).sum() / (this.messWerte.size() * 1.00);
        }
    }
}

