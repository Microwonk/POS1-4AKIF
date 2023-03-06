package Theorie.Kap2.MyTreeElement_12;

public class Main {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        MyTreeElement root = new MyTreeElement('a');
        root.add('c');
        root.add('b');
        root.add('c');
        root.add('d');
        root.add('e');
        root.add('f');
        root.add('g');
        root.add('h');
        root.add('i');
        root.add('j');
        System.out.println(root.count('b'));
    }
}
