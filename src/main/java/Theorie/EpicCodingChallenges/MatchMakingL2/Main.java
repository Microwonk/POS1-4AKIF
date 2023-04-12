package Theorie.EpicCodingChallenges.MatchMakingL2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

    private static ArrayList<Match> matches = new ArrayList <>();
    private static int[] wins;

    public static void main (String[] args) {
        start();
    }

    private static void start () {
        System.out.println("file name: ");
        try {
            load(new Scanner(System.in).nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // matches.forEach(System.out::println);

        matches.forEach(e -> {
            if (e.scP1 > e.scP2) {
                wins[e.p1] += 1;
            } else {
                wins[e.p2] += 1;
            }
        });

        for (int i = 0; i < wins.length; i++) {
            System.out.println(i + " " + wins[i]);
        }
    }

    private static void load(String file) throws Exception {
        BufferedReader br = new BufferedReader
                (new FileReader
                        ("src/main/java/Theorie/EpicCodingChallenges/MatchMakingL2/test/level2_" + file + ".in"));
        String curr = br.readLine();
        wins = new int[Integer.parseInt(curr.split(" ")[1])];
        while (true) {
            curr = br.readLine();
            if (curr == null) return;
            String[] temp = curr.split(" ");
            matches.add(new Match(Integer.parseInt(temp[0])
                    , Integer.parseInt(temp[1])
                    , Integer.parseInt(temp[2])
                    , Integer.parseInt(temp[3])));
        }
    }


    private static class Match {
        int p1;
        int scP1;
        int p2;
        int scP2;

        public Match (int p1, int scP1, int p2, int scP2) {
            this.p1 = p1;
            this.scP1 = scP1;
            this.p2 = p2;
            this.scP2 = scP2;
        }

        @Override
        public String toString () {
            return "Match{" +
                    "plID1=" + p1 +
                    ", scorePl1=" + scP1 +
                    ", plID2=" + p2 +
                    ", scorePl2=" + scP2 +
                    '}';
        }
    }
}
