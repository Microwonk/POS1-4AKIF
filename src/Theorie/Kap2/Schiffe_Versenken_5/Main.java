package Theorie.Kap2.Schiffe_Versenken_5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        final SchiffeVersenken schiffeVersenken = new SchiffeVersenken(10, 10);
        boolean success;

        success = schiffeVersenken.setDestroyer(new int[][]{{1, 1},{2, 1},{3, 1}});
        System.out.println(success);
        System.out.println(schiffeVersenken.drawField());

        success = schiffeVersenken.setFreightShip
                (new int[][]{{1,1},{1,2},{1,3},{1,4}}); // wird nicht funktionieren, weil es Überlappt
        System.out.println(success);
        System.out.println(schiffeVersenken.drawField());

        success = schiffeVersenken.setFreightShip(new int[][]{{1,3},{1,4},{1,5},{1,6}});
        System.out.println(success);
        System.out.println(schiffeVersenken.drawField());

        success = schiffeVersenken.setSmallShip(new int[][]{{5,6},{6,6}});
        System.out.println(success);
        System.out.println(schiffeVersenken.drawField());
    }


    static class SchiffeVersenken {
        private static final char WATER = ' ';
        private static final char FREIGHT_SHIP = 'F';
        private static final char DESTROYER = 'D';
        private static final char SMALL_SHIP = 'S';

        private final char[][] FIELD;
        private final int WIDTH;
        private final int HEIGHT;

        public SchiffeVersenken(final int height, final int width) {
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
        public String drawField() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < HEIGHT * WIDTH; i++) {
                sb.append(this.FIELD[i / WIDTH][i % WIDTH]).append(",");
                if ((i + 1) % WIDTH == 0) {
                    sb.append(System.lineSeparator());
                }
            }
            return sb.toString();
        }


        public boolean setFreightShip(final int[][] locations) {
            // wenn Schiffe überlappen, fails
            if (Arrays.stream(locations).anyMatch(ints -> this.FIELD[ints[0]][ints[1]] != WATER)) {
                return false;
            }
            if (locations.length == 4 && isLocationsValid(locations)) {
                for (int[] coordinate: locations) {
                    this.FIELD[coordinate[0]][coordinate[1]] = FREIGHT_SHIP;
                }
                return true;
            }
            return false;
        }

        public boolean setDestroyer(final int[][] locations) {
            // wenn Schiffe überlappen, fails
            if (Arrays.stream(locations).anyMatch(ints -> this.FIELD[ints[0]][ints[1]] != WATER)) {
                return false;
            }
            if (locations.length == 3 && isLocationsValid(locations)) {
                for (int[] coordinate: locations) {
                    this.FIELD[coordinate[0]][coordinate[1]] = DESTROYER;
                }
                return true;
            }
            return false;
        }

        public boolean setSmallShip(final int[][] locations) {
            // wenn Schiffe überlappen, fails
            if (Arrays.stream(locations).anyMatch(ints -> this.FIELD[ints[0]][ints[1]] != WATER)) {
                return false;
            }
            if (locations.length == 2 && isLocationsValid(locations)) {
                for (int[] coordinate: locations) {
                    this.FIELD[coordinate[0]][coordinate[1]] = SMALL_SHIP;
                }
                return true;
            }
            return false;
        }

        // berechnet, wenn ein Schiff angereiht, gerade und auf dem Feld ist.
        private boolean isLocationsValid(final int[][] locations) {
            if (!isOnField(locations)) return false;
            int[] a = new int[locations.length];
            int[] b = new int[locations.length];
            for (int i = 0; i < locations.length; i++) {
                a[i] = locations[i][0];
                b[i] = locations[i][1];
            }
            return Arrays.stream(a).allMatch(candidate -> candidate == a[0])
                    || Arrays.stream(b).allMatch(candidate -> candidate == b[0])
                    && isAdjacent(a) || isAdjacent(b);
        }

        // alle Koordinaten sind nebeneinander → kein Schiff dieser Form (F,F, ,F, ,F)
        private boolean isAdjacent(final int[] a) {
            return IntStream.range(0, a.length - 1)
                    .allMatch(i -> a[i] == a[i+1] - 1);
        }

        // ist auf dem Feld des 2D arrays
        private boolean isOnField(final int[][] locations) {
            if (!(locations.length <= this.FIELD.length)) return false;
            return Arrays.stream(locations).count()
                    <= Arrays.stream(this.FIELD).count();
        }
    }
}

