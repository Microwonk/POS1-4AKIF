package Theorie.Kap2.MyListElement_6;

public class MyListElement<E> {

    private E element;
    private MyListElement<E> next;
    private int size;

    // may not need this constructor
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
        } else if (!hasNext()) {
            this.next = new MyListElement<>(newElement);
        } else {
            this.next.add(newElement);
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    // TODO: remove and set Method

    public boolean remove(final int index) {
        if (index > size || index < 0) {
            return false; // not in bounds
        } else if (index == 0) {

            return true;
        } else if (index == 1) {
            return true;
        } else {
            return true;
        }
    }

    public boolean set(final int index, final E element) {
        if (index > size || index < 0) {
            return false; // not in bounds
        } else if (index == 0) {
            this.element = element;
            return true;
        } else if (index == 1) {
            this.next.element = element;
            return true;
        } else {
            next.set(index-1, element);
            return true;
        }
    }

    public E get(final int index) {
        if (index > size) {
            throw new RuntimeException("Index Out Of Bounds Exception");
        } else if (index == 0) {
            return this.element;
        } else if (index == 1) {
            return this.next.element;
        }
        return next.get(index - 1);
    }

    // get a specific Element from the list using an Element that contains
    public int getIndex(final E element) {
        int index = 1;
        if (this.element == element) {
            return 0;
        } else if (this.hasNext() && this.next.element == element) {
            return 1;
        } else if (this.hasNext() && this.next.element != element) {
            return index + next.getIndex(element);
        } else {
            return Integer.MIN_VALUE; // if the Element is not contained in it -> should be made better
        }
    }

    public boolean contains(final E element) {
        if (this.element == element) {
            return true;
        } else if (this.hasNext() && this.next.element == element) {
            return true;
        } else if (this.hasNext() && this.next.element != element) {
            return next.contains(element);
        } else {
            return false; // if the Element is not contained in it
        }
    }

    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public String toString() {
        return  element.toString().concat("\n") +
                (next == null ? "" : next.toString());
    }
}
