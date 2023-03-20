package Theorie.Kap2.Schiffe_Versenken_5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main (String[] args) {
        test();
    }

    private static void test () {
        final SchiffeVersenken schiffeVersenken = new SchiffeVersenken(10, 10);

        System.out.println(schiffeVersenken.setNewDestroyer(new int[][]{{1, 1}, {2, 1}, {3, 1}}));
        System.out.println(schiffeVersenken.drawField());

        // wird nicht funktionieren, weil es Überlappt -> false
        System.out.println(schiffeVersenken.setNewFreightShip(new int[][]{{1, 1}, {1, 2}, {1, 3}, {1, 4}}));
        System.out.println(schiffeVersenken.drawField());

        System.out.println(schiffeVersenken.setNewFreightShip(new int[][]{{1, 3}, {1, 4}, {1, 5}, {1, 6}}));
        System.out.println(schiffeVersenken.drawField());

        System.out.println(schiffeVersenken.setNewSmallShip(new int[][]{{6, 6}, {7, 6}}));
        System.out.println(schiffeVersenken.drawField());

        System.out.println(schiffeVersenken.setNewSmallShip(new int[][]{{8, 6}, {9, 6}}));
        System.out.println(schiffeVersenken.drawField());

        System.out.println(schiffeVersenken.setNewSmallShip(new int[][]{{5, 4}, {6, 4}}));
        System.out.println(schiffeVersenken.drawField());

        System.out.println(schiffeVersenken.setNewSmallShip(new int[][]{{8, 3}, {8, 4}}));
        System.out.println(schiffeVersenken.drawField());

        System.out.println(schiffeVersenken.setNewSmallShip(new int[][]{{0, 9}, {0, 8}}));
        System.out.println(schiffeVersenken.drawField());

        System.out.println(schiffeVersenken.setNewSmallShip(new int[][]{{0, 7}, {0, 6}}));
        System.out.println(schiffeVersenken.drawField());
    }


    static class SchiffeVersenken {
        private static final char WATER = ' ';
        private static final char FREIGHT_SHIP = 'F';
        private static final char DESTROYER = 'D';
        private static final char SMALL_SHIP = 'S';
        private static final int NUM_OF_DESTROYER = 2;
        private static final int NUM_OF_SMALL_SHIPS = 4;
        private static final int NUM_OF_FREIGHT_SHIPS = 1;
        private static final int MAX_NUM_OF_SHIPS = NUM_OF_FREIGHT_SHIPS + NUM_OF_DESTROYER + NUM_OF_SMALL_SHIPS;
        private static int AMOUNT_OF_CURRENT_SHIPS = 0;

        private final char[][] FIELD;
        private final int WIDTH;
        private final int HEIGHT;

        public SchiffeVersenken (final int height, final int width) {
            this.HEIGHT = height;
            this.WIDTH = width;
            this.FIELD = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    this.FIELD[i][j] = WATER;
                }
            }
        }

        // mit nur einem loop und modulo operator das Feld darstellen
        public String drawField () {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < HEIGHT * WIDTH; i++) {
                sb.append(this.FIELD[i / WIDTH][i % WIDTH]).append(",");
                if ((i + 1) % WIDTH == 0) {
                    sb.append(System.lineSeparator());
                }
            }
            return sb.toString();
        }


        public boolean setNewFreightShip (final int[][] locations) {
            // wenn Schiffe überlappen, fails
            if (Arrays.stream(locations).anyMatch(ints -> this.FIELD[ints[0]][ints[1]] != WATER ||
                    AMOUNT_OF_CURRENT_SHIPS >= MAX_NUM_OF_SHIPS)) {
                return false;
            }
            if (locations.length == 4 && isLocationsValid(locations)) {
                for (int[] coordinate : locations) {
                    this.FIELD[coordinate[0]][coordinate[1]] = FREIGHT_SHIP;
                }
                AMOUNT_OF_CURRENT_SHIPS++;
                return true;
            }
            return false;
        }

        public boolean setNewDestroyer (final int[][] locations) {
            // wenn Schiffe überlappen, fails
            if (Arrays.stream(locations).anyMatch(ints -> this.FIELD[ints[0]][ints[1]] != WATER ||
                    AMOUNT_OF_CURRENT_SHIPS >= MAX_NUM_OF_SHIPS)) {
                return false;
            }
            if (locations.length == 3 && isLocationsValid(locations)) {
                for (int[] coordinate : locations) {
                    this.FIELD[coordinate[0]][coordinate[1]] = DESTROYER;
                }
                AMOUNT_OF_CURRENT_SHIPS++;
                return true;
            }
            return false;
        }

        public boolean setNewSmallShip (final int[][] locations) {
            // wenn Schiffe überlappen, fails
            if (Arrays.stream(locations).anyMatch(ints -> this.FIELD[ints[0]][ints[1]] != WATER ||
                    AMOUNT_OF_CURRENT_SHIPS >= MAX_NUM_OF_SHIPS)) {
                return false;
            }
            if (locations.length == 2 && isLocationsValid(locations)) {
                for (int[] coordinate : locations) {
                    this.FIELD[coordinate[0]][coordinate[1]] = SMALL_SHIP;
                }
                AMOUNT_OF_CURRENT_SHIPS++;
                return true;
            }
            return false;
        }

        // berechnet, wenn ein Schiff angereiht, gerade und auf dem Feld ist. + dass es keine gleichen locations gibt!
        private boolean isLocationsValid (final int[][] locations) {
            return isOnField(locations)
                    && IntStream.range(1, locations.length)
                    .noneMatch(i -> Arrays.equals(locations[i], locations[i - 1]))
                    && ((Arrays.stream(locations).allMatch(coordinate -> coordinate[0] == locations[0][0])
                    || Arrays.stream(locations).allMatch(coordinate -> coordinate[1] == locations[0][1]))
                    && (isAdjacent(Arrays.stream(locations).mapToInt(coordinate -> coordinate[0]).toArray())
                    || isAdjacent(Arrays.stream(locations).mapToInt(coordinate -> coordinate[1]).toArray())));
        }


        // alle Koordinaten sind nebeneinander → kein Schiff dieser Form (F,F, ,F, ,F)
        private boolean isAdjacent (final int[] a) {
            return IntStream.range(0, a.length - 1)
                    .allMatch(i -> a[i] == a[i + 1] - 1);
        }

        // ist auf dem Feld des 2D arrays
        private boolean isOnField (final int[][] locations) {
            if (!(locations.length <= this.FIELD.length)) return false;
            return Arrays.stream(locations).count()
                    <= Arrays.stream(this.FIELD).count();
        }
    }
}

