package Theorie.Kap6._4_MyListElement;

public interface MyList<E> {
    void add(E value);
    void add(E value, int index);
    E get(int index);
    E remove(int index);
    int size();
}
