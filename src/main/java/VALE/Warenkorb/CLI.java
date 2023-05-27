package VALE.Warenkorb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class CLI {

    private final static List<Produkt> PRODUKTE = new ArrayList <>();
    private final static Warenkorb WARENKORB = new Warenkorb();

    public static void main (String[] args) {
        menu();
    }

    private static void menu () {
        final Scanner scan = new Scanner(System.in);
        int pNr, inp;
        String pName, pPreis;
        boolean produkt;

        while (true) {
            System.out.println("1-Produkt anlagen, 2- Produktliste, 3-Produkt in Warenkorb legen, 4-Warenkorb anzeigen, 5-Produkt entfernen, 6-Ende");
            inp = Integer.parseInt(scan.nextLine());
            switch (inp) {
                case 1 -> {
                    System.out.println("Produkt oder Nahrungsmittelprodukt? (P, N)");
                    produkt = scan.nextLine().equalsIgnoreCase("P");
                    System.out.println("Produktnummer eingeben");
                    pNr = Integer.parseInt(scan.nextLine());
                    System.out.println("Produktname eingeben");
                    pName = scan.nextLine();
                    System.out.println("Produktpreis eingeben");
                    pPreis = scan.nextLine();
                    if (produkt) {
                        PRODUKTE.add(new Produkt(pNr, pName, pPreis));
                    } else {
                        System.out.println("Geben sie allergene ein: A-F");
                        PRODUKTE.add(new NahrungsmittelProdukt(pNr, pName, pPreis, genAllergene(scan.nextLine())));
                    }


                }
                case 2 -> produkteAnzeigen();
                case 3 -> {
                    System.out.println("Geben sie die Nummer des Produktes ein.");
                    produktHinzufugen(Integer.parseInt(scan.nextLine()));
                }
                case 4 -> warenKorbAnzeigen();
                case 5 -> {
                    System.out.println("Geben sie die Nummer der Produktes ein.");
                    produktLoschen(Integer.parseInt(scan.nextLine()));
                }
                case 6 -> {return;}
                default -> System.out.println("Falscher input!");
            }
        }
    }

    private static HashSet <NahrungsmittelProdukt.Allergen> genAllergene (String allergenCode) {
        final HashSet<NahrungsmittelProdukt.Allergen> toReturn = new HashSet <>();
        for (char c: allergenCode.toCharArray()) {
            switch (c) {
                case 'A' -> toReturn.add(NahrungsmittelProdukt.Allergen.A);
                case 'B' -> toReturn.add(NahrungsmittelProdukt.Allergen.B);
                case 'C' -> toReturn.add(NahrungsmittelProdukt.Allergen.C);
                case 'D' -> toReturn.add(NahrungsmittelProdukt.Allergen.D);
                case 'E' -> toReturn.add(NahrungsmittelProdukt.Allergen.E);
                case 'F' -> toReturn.add(NahrungsmittelProdukt.Allergen.F);
            }
        }
        return toReturn;
    }

    public static void produkteAnzeigen () {
        PRODUKTE.forEach(System.out::println);
    }

    public static void produktHinzufugen (int produktNummer) {
        WARENKORB.addProdukt(PRODUKTE.stream().filter(p -> p.getpNr() == produktNummer).toList().get(0));
    }

    public static void produktLoschen (int produktNummer) {
        WARENKORB.removeProdukt(produktNummer);
    }

    public static void warenKorbAnzeigen () {
        WARENKORB.getWarenKorbInhalt().forEach((produkt, v) -> System.out.println(produkt + "anzahl: " + v));
    }
}
