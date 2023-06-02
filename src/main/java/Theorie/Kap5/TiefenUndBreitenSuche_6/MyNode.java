package Theorie.Kap5.TiefenUndBreitenSuche_6;

import java.util.ArrayList;
import java.util.List;

public class MyNode <E> {
    private final E element;
    private final List<MyNode<E>> children;

    public MyNode (final E element) {
        this.children = new ArrayList<>();
        this.element = element;
    }

    public boolean add(final E toAdd) {
        return this.children.add(new MyNode<>(toAdd));
    }

    public boolean add(final MyNode<E> node) {
        return this.children.add(node);
    }

    public E getElement () {
        return this.element;
    }

    public List<MyNode<E>> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
