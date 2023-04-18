package VALE.CD_DVD;

import java.util.Scanner;

public class Main {

    private final static MedienDB medien = new MedienDB();

    private static void start () {
        Scanner scanner = new Scanner(System.in);
        String suche = null;
        while (true) {
            System.out.println("1: add | 2: suche | 3: ausgabe | 4: suche(gespeichert) löschen | 5: ende");
            int inp;
            try {
                inp = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }

            switch (inp) {
                case 1 -> add(scanner);
                case 2 -> {
                    suche = scanner.nextLine();
                    System.out.println(medien.findMedien(suche));
                }
                case 3 -> System.out.println(ausgabe(scanner));
                case 4 -> System.out.println(medien.deleteMedien(suche) ? "Erfolgreich" : "Nicht Erfolgreich");
                case 5 -> {
                    return;
                }
            }
        }
    }

    private static String ausgabe(Scanner scanner) {
        System.out.println("1: alle CDs | 2: alle DVDs | 3: alle");
        try {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> {return medien.CDStoString();}
                case 2 -> {return medien.DVDStoString();}
                default -> {return medien.toString();}
            }
        } catch (Exception e) {
            return "Falsche Eingabe";
        }
    }

    private static void add(Scanner scanner) {
        try {
            System.out.println("Typ:");
            String typ = scanner.nextLine();
            System.out.println("Titel:");
            String titel = scanner.nextLine();
            System.out.println("Genre:");
            String genre = scanner.nextLine();
            System.out.println("Dauer:");
            int dauer = Integer.parseInt(scanner.nextLine());
            System.out.println("Verliehen (ja/nein)");
            boolean verliehen = scanner.nextLine().equalsIgnoreCase("ja");


            System.out.println("CD oder DVD?");
            String dec = scanner.nextLine();
            if (dec.equalsIgnoreCase("CD")) {
                System.out.println("Künstler: ");
                String kuenstler = scanner.nextLine();

                medien.add(new CD(typ, titel, genre, kuenstler, dauer, verliehen));

            } else if (dec.equalsIgnoreCase("DVD")){
                System.out.println("Regisseur: ");
                String reg = scanner.nextLine();

                medien.add(new DVD(typ, titel, genre, reg, dauer, verliehen));
            } else {
                System.out.println("Falsche Eingabe");
            }
        } catch (Exception e) {
            System.out.println("Falsche Eingabe");
        }
    }

    public static void main (String[] args) {
        start();
    }
}
