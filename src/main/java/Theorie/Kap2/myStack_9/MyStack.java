package Theorie.Kap2.myStack_9;

public class MyStack<E> {
    private final Object[] elements;
    private int size;

    MyStack(final int size) {
        this.elements = new Object[size];
        this.size = 0;
    }

    void push(final E element) {
        if (!(this.size < this.elements.length)) {
            System.out.println("myStack full");
            return;
        }
        this.elements[this.size] = element;
        this.size++;
    }
    E pop() {
        if (this.size == 0) {
            System.out.println("myStack empty");
            return null;
        }
        this.size--;
        final E popped = (E) this.elements[this.size];
        this.elements[this.size] = null;
        return popped;
    }
    Object peek() {
        if (this.size == 0) {
            System.out.println("myStack empty");
            return null;
        } else if (!(this.size < this.elements.length)) {
            System.out.println("myStack full");
        }
        return this.elements[this.size - 1];
    }
}
