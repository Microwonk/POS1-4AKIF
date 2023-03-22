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

    public void add(final E newElement) {
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

    public E remove(final int index) {
        E removedElement;
        if (index >= size || index < 0) {
            throw new RuntimeException("Index Out Of Bounds Exception");
        } else if (index == 0) {
            removedElement = this.element;
            this.element = next.element;
            this.next = hasNext() ? next.next : null; // wenn kein nächstes vorhanden ist, wird das letzte gelöscht
            this.size--;
        } else {
            removedElement = next.remove(index - 1);
            this.size--;
        }
        return removedElement;
    }

    public E set(final int index, final E element) {
        E oldElement;
        if (index >= size || index < 0) {
            throw new RuntimeException("Index Out Of Bounds Exception");
        } else if (index == 0) {
            oldElement = this.element;
            this.element = element;
        } else if (index == 1 && hasNext()) {
            oldElement = this.next.element;
            this.next.element = element;
        } else {
            oldElement = next.set(index - 1, element);
        }
        return oldElement;
    }

    public E get(final int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("Index Out Of Bounds Exception");
        }
        return index == 0 ? this.element : next.get(index - 1);
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
            return Integer.MIN_VALUE; // if the Element is not contained in it -> should be made better ?
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

    public void clear() {
        this.element = null;
        this.size = 0;
        if (hasNext()) {
            this.next = null;
        }
    }

    public boolean addAll(final java.util.Collection<E> c) {
        if (c == null) {
            return false;
        }
        // casts the Collection to custom type
        final MyListElement<E> listElement = c.stream()
                .collect(MyListElement::new, MyListElement::add, MyListElement::addAll);
        return addAll(listElement);
    }

    public boolean addAll(final MyListElement<E> listElement) {
        if (listElement == null) {
            return false;
        }
        if (this.element == null) {
            this.element = listElement.element;
            this.next = listElement.next;
        } else if (hasNext()) {
            this.next.addAll(listElement);
        } else {
            this.next = listElement;
        }
        this.size += listElement.size();
        return true;
    }

    // iterativ
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        MyListElement<E> current = this;
        sb.append(current.element.toString()).append('\n');
        do {
            current = current.next;
            sb.append(current.element.toString()).append('\n');
        } while (current.hasNext());
        return  sb.toString();
    }

    // rekursiv
  /*  @Override
    public String toString() {
        return  element.toString().concat("\n") +
                (next == null ? "" : next.toString());
    }*/
    public E getElement() {
        return element;
    }

    public MyListElement<E> getNext() {
        return next;
    }
}