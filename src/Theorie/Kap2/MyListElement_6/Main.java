package Theorie.Kap2.MyListElement_6;

public class Main {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        MyListElement<Integer> customList = new MyListElement<>(1);
        MyListElement<Integer> customEmptyList = new MyListElement<>();

        System.out.println(customList.size());
        customList.add(4);
        System.out.println(customList.size());
        customList.add(5);
        System.out.println(customList.size());
        customList.add(6);

        System.out.println(customList);
        System.out.println(customList.get(2));
        System.out.println(customList.size());
    }
}
