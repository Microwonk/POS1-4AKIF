package Theorie.Kap5.Dijkstra;

public class Main {
    public static void main (String[] args) {
        int[][] matrix = {
                {0, 10, 0, 30, 100},
                {10, 0, 50, 0, 0},
                {0, 50, 0, 20, 10},
                {30, 0, 20, 0, 60},
                {100, 0, 10, 60, 0}
        };

        DijkstraAlgo dijkstra = new DijkstraAlgo(matrix, 0, 3);
        dijkstra.shortestPath();
    }
}
