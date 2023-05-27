package Theorie.EpicCodingChallenges.MatchMakingL2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    private static final List <Match> matches = new ArrayList <>();

    public static void main (String[] args) {
        // auswahl des files
        System.out.println("file name: ");
        try {
            load(new Scanner(System.in).nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Map aller Spieler IDs, dazugehörig die Wins mit Integer::sum und map.merge
        Map <Integer, Integer> wins = matches.stream()
                .collect(HashMap::new,
                        (map, match) -> map.merge(match.scP1 > match.scP2 ? match.p1 : match.p2, 1, Integer::sum),
                        HashMap::putAll);

        sortWins(wins).forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    private static void load (String file) throws Exception {
        BufferedReader br = new BufferedReader
                (new FileReader
                        ("src/main/java/Theorie/EpicCodingChallenges/MatchMakingL2/test/level2_" + file + ".in"));
        String curr = br.readLine();
        while (true) {
            curr = br.readLine();
            if (curr == null) return;
            String[] temp = curr.split(" ");
            matches.add(new Match(
                      Integer.parseInt(temp[0])
                    , Integer.parseInt(temp[1])
                    , Integer.parseInt(temp[2])
                    , Integer.parseInt(temp[3])
                    )
            );
        }
    }

    // mapped alle wins in reverse order
    private static Stream <Map.Entry <Integer, Integer> > sortWins (Map <Integer, Integer> wins) {
        return wins.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed());
    }

    private record Match(int p1, int scP1, int p2, int scP2) {
    }
}
