package Theorie.Kap2.myStack_9;

public class Main {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        MyStack<Integer> myStack = new MyStack<>(6);
        myStack.peek();
        myStack.pop();
        for (int i = 0; i < 6; i++) {
            myStack.push(i);
        }
        myStack.push(2);
        myStack.push(2);
        myStack.push(7);
        myStack.peek();
        Integer i = myStack.pop();
        System.out.println(i);
        System.out.println(myStack.peek());
    }
}
