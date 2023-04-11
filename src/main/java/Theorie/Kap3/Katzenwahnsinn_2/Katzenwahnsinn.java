package Theorie.Kap3.Katzenwahnsinn_2;

import java.util.ArrayList;
import java.util.List;

public class Katzenwahnsinn {

    private static List <Katze> tierschuetzer = new ArrayList <>();
    private final static String KATZE = "Katze ";

    public static void main(String[] args) {
    }

    private static void start () {
        for(int i=0; i<4; i++) {
            machKatzen(1000000);
            warten(5000);
        }
    }

    private static void startListe () {
        for(int i=0; i<4; i++) {
            machKatzenListe(1000000);
            warten(5000);
        }
    }

    private static void machKatzen(int anzahl) {
        for(int i=0; i<anzahl; i++) {
            Katze katze = new Katze(KATZE + i);
        }
    }

    private static void machKatzenListe(int anzahl) {
        for(int i=0; i<anzahl; i++) {
            tierschuetzer.add(new Katze(KATZE + i));
        }
    }


    private static void warten(long millisekunden) {
        try {
            Thread.sleep(millisekunden);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Katze {
    private final String name;
    public Katze(String name) {
        this.name = name;
    }
}

