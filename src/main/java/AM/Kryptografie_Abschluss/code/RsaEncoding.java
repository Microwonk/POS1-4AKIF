package AM.Kryptografie_Abschluss.code;

import java.util.Scanner;

public class RsaEncoding {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib den Teil n des öffentlichen Schlüssels ein! ");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.print("Gib den Teil a des öffentlichen Schlüssels ein! ");
        int a = Integer.parseInt(scanner.nextLine());

        while (true) {
            String text = "Gib eine zu verschlüsselnde Nachricht ein, die kleiner als n = " + n + " ist ";
            long t;
            while (true) {
                System.out.print(text);
                t = Long.parseLong(scanner.nextLine());
                if (t >= n) {
                    System.out.println("Eingabefehler: Nachricht ist grösser oder gleich n; Eingabe wiederholen! ");
                } else {
                    break;
                }
            }

            int tn = (int) (t % n);
            int x = tn;
            for (int i = 0; i < a - 1; i++) {
                x = (x * tn) % n;
            }

            System.out.println("Die verschlüsselte Nachricht lautet: " + x);
            System.out.println();

            while (true) {
                try {
                    System.out.print("Noch eine Nachricht verschlüsseln? 1 für ja, 0 für nein eingeben ");
                    int input = Integer.parseInt(scanner.nextLine());
                    if (input == 0) {
                        break;
                    } else if (input == 1) {
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("Please answer the question!");
                    scanner.nextLine();
                }
            }
        }
    }
}
