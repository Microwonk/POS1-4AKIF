package Theorie.Kap5.Dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    private static final int INF = Integer.MAX_VALUE;

    private int[][] matrix;
    private int source;
    private int end;

    public DijkstraAlgo (int[][] matrix, int source, int end) {
        this.matrix = matrix;
        this.source = source;
        this.end = end;
    }

    public void shortestPath() {

        int numVertices = matrix.length;

        // Initialize the distance array
        int[] distance = new int[numVertices];
        Arrays.fill(distance, INF);
        distance[source] = 0;

        // Initialize the visited array
        boolean[] visited = new boolean[numVertices];

        // Initialize the priority queue with the start vertex
        PriorityQueue<Integer> queue = new PriorityQueue<>(numVertices, Comparator.comparingInt(o -> distance[o]));
        queue.offer(source);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited[u] = true;

            if (u == end) {
                break;
            }

            // Update the distances of adjacent vertices
            for (int v = 0; v < numVertices; v++) {
                if (matrix[u][v] != 0 && !visited[v]) {
                    int newDistance = distance[u] + matrix[u][v];
                    if (newDistance < distance[v]) {
                        distance[v] = newDistance;
                        queue.offer(v);
                    }
                }
            }
        }

        // Print the shortest distance
        System.out.println("Shortest distance from " + source + " to " + end + " is " + distance[end]);
    }
}
