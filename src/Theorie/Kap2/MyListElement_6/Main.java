package Theorie.Kap2.MyListElement_6;

public class Main {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        MyListElement<Integer> customList = new MyListElement<>();

        for (int i = 0; i < 100; i++) {
            customList.add(i);
        }

        System.out.println(customList.get(3));
        customList.set(3, 90);
        System.out.println(customList.contains(5));
        System.out.println(customList.getIndex(100));
        System.out.println(customList.size());
    }
}
