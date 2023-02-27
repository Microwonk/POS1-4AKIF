package Theorie.Kap2.MyListElement_6;

public class MyListElement<E> {

    private E element;
    private MyListElement<E> next;
    private int size;

    public MyListElement(E element) {
        this.element = element;
        this.next = null;
        this.size = 1;
    }

    public MyListElement() {
        this.element = null;
        this.next = null;
        this.size = 0;
    }

    public void add(E newElement) {
        if (this.element == null) {
            this.element = newElement;
        } else if (this.next == null) {
            this.next = new MyListElement<>(newElement);
        } else {
            this.next.add(newElement);
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public E get(final int index) {
        if (index > size) {
            throw new RuntimeException("Index Out Of Bounds Exception");
        }
        if (index == 0) {
            return this.element;
        }
        if (index == 1) {
            return this.next.element;
        }
        return next.get(index-1);
    }

    @Override
    public String toString() {
        return  element.toString().concat("\n") +
                (next == null ? "" : next.toString());
    }
}
