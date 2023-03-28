package Theorie.Kap2.MyTreeElement_12;

public class Main {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        MyTreeElement root = new MyTreeElement('e');
        root.add('c');
        root.add('b');
        root.add('c');
        root.add('d');
        root.add('f');
        root.add('g');
        root.add('h');
        root.add('i');
        root.add('j');
        root.add('e');
        System.out.println(root.count('e'));
        System.out.println(root.count('b'));
        System.out.println(root.count('f'));
        System.out.println(root.count('d'));
        System.out.println(root.count('j'));

        System.out.println(root.count('a'));

    }
}
