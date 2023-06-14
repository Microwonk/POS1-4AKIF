package Theorie.Kap5.TiefenUndBreitenSuche_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        MyNode<Integer> rootNode = new MyNode<>(0);
        MyNode<Integer> node1 = new MyNode<>(1);

        MyNode<Integer> node2 = new MyNode<>(2);
        MyNode<Integer> node3 = new MyNode<>(3);
        MyNode<Integer> node4 = new MyNode<>(4);

        rootNode.add(node1);
        rootNode.add(node2);
        node1.add(node3);
        node2.add(node4);

        dfs(rootNode, 4);
        System.out.println();
        bfs(rootNode, 4);
    }

    private static MyNode<Integer> dfs(final MyNode<Integer> start, final int goal) {
        final Stack<MyNode<Integer>> stack = new Stack<>(); // Stack für die Tiefensuche
        stack.push(start); // Startknoten

        while (!stack.isEmpty()) {
            final MyNode<Integer> current = stack.pop(); // Aktuellen Knoten vom Stack abrufen

            System.out.println(current); // prüfen

            if (current.getElement() == goal) {
                return current; // Zielknoten gefunden, Rückgabe
            }

            current.getChildren().forEach(stack::push); // Kindknoten zum Stack hinzufügen
        }
        return null; // Zielknoten nicht gefunden
    }

    private static MyNode<Integer> bfs (final MyNode<Integer> start, final int goal) {
        Queue<MyNode<Integer>> queue = new LinkedList<>();
        queue.offer(start); // Startknoten in die Warteschlange einfügen

        while (!queue.isEmpty()) {
            MyNode<Integer> current = queue.poll(); // Aktuellen Knoten aus der Warteschlange entfernen

            System.out.println(current); // prüfen

            if (current.getElement() == goal) {
                return current; // Zielknoten gefunden, Rückgabe
            }

            current.getChildren().forEach(queue::offer); // Kindknoten in die Warteschlange einfügen
        }

        return null; // Zielknoten nicht gefunden
    }
}
