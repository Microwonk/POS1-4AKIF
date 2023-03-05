package Theorie.Kap2.HashMap_11;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Map<String, Integer> monateTage = new HashMap<>();
        monateTage.put("Januar", 31);
        monateTage.put("Februar", 28);
        monateTage.put("März", 31);
        monateTage.put("April", 30);
        monateTage.put("Mai", 31);
        monateTage.put("Juni", 30);
        monateTage.put("Juli", 31);
        monateTage.put("August", 31);
        monateTage.put("September", 30);
        monateTage.put("Oktober", 31);
        monateTage.put("November", 30);
        monateTage.put("Dezember", 31);

        System.out.println("Januar: " + monateTage.get("Januar"));

        int sum = 0;
        for (String s: monateTage.keySet()) {
            System.out.println(s + " hat " + monateTage.get(s) + " Tage.");
            sum += monateTage.get(s);
        }
        System.out.println("Durchschnitt: " + sum / (monateTage.size() * 1.0));
    }
}
