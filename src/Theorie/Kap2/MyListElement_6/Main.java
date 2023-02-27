package Theorie.Kap2.MyListElement_6;

public class Main {
    public static void main(String[] args) {
        test();
    }

    // TODO: write actual sophisticated tests
    private static void test() {
        MyListElement<Integer> recursiveList = new MyListElement<>();
        MyListElement<Integer> customList = new MyListElement<>();

        for (int i = 0; i < 100; i++) {
            recursiveList.add(i);
        }

        for (int i = 0; i < 40; i++) {
            customList.add(i);
        }
        
        System.out.println(recursiveList.set(73, 79));
        System.out.println(recursiveList.get(73));
        System.out.println(recursiveList.remove(88));
        System.out.println(recursiveList.addAll(customList));
        System.out.println();
        System.out.println(recursiveList);
    }
}
