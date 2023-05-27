package Theorie.EpicCodingChallenges.QuantumBreakdownL2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(input());
        List<Flight> flights = new ArrayList <>();

        br.readLine();

        while (true) {
            String curr = br.readLine();
            if (curr == null) break;
            String[] split = curr.split(",");
            flights.add(new Flight(split[4], split[5]));
        }

        Map<Flight, Long> flightCount = flights.stream()
                .collect(Collectors.groupingBy(flight -> flight, Collectors.counting()));

        sortFlights(flightCount).forEach((k,v) -> System.out.println(k + " " + v));
    }

    private static Map<Flight, Long> sortFlights (Map<Flight, Long> map) {

        return map.entrySet().stream().sorted(Comparator.comparing((Map.Entry<Flight, Long> entry) -> entry.getKey().A())
                        .thenComparing(entry -> entry.getKey().B()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    }

    private static FileReader input () throws Exception {
        System.out.println("file: ");
        return new FileReader(
                "src/main/java/Theorie/EpicCodingChallenges/QuantumBreakdownL2/test/level2_"
                        + new Scanner(System.in).nextLine() + ".in");
    }

    private record Flight (String A, String B) {
        @Override
        public String toString () {
            return A + " " + B;
        }
    }
}