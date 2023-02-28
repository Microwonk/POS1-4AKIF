package Theorie.Kap2.MyListElement_6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MyListElementTest {

    void create() {
        MyListElement<Integer> list = new MyListElement<>();
        for (int i = 0; i < 25000; i++) {
            list.add(i);
        }
    }

    @Test
    void add() {
        assertNotNull(new MyListElement<>(10).getElement());
        assertNull(new MyListElement<>().getElement());
        assertFalse(new MyListElement<>(10).hasNext());
        MyListElement<Integer> s = new MyListElement<>(10);
        s.add(8);
        assertTrue(s.hasNext());
        s.add(5);
        assertTrue(s.getNext().hasNext());
    }

    @Test
    void size() {
        MyListElement<Integer> list = new MyListElement<>();
        assertEquals(0, list.size());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
        list.addAll(list);
        assertEquals(20, list.size());
    }

    @Test
    void remove() {
        MyListElement<Integer> s = new MyListElement<>(10);
        s.add(3);
        s.add(4);
        assertEquals(3, s.size());
        assertEquals(s.get(1), s.remove(1));
        assertEquals(2, s.size());
    }

    @Test
    void set() {
        MyListElement<Integer> s = new MyListElement<>(10);
        s.add(3);
        s.add(4);
        assertEquals(s.get(1), s.set(1, 100));
        assertEquals(100, s.get(1));
        assertEquals(3, s.size());
    }

    @Test
    void get() {
        MyListElement<Integer> s = new MyListElement<>(10);
        s.add(3);
        s.add(4);
        assertEquals(3, s.get(1));
        assertEquals(10, s.get(0));
        assertEquals(4, s.get(2));
    }

    @Test
    void getIndex() {
        MyListElement<Integer> s = new MyListElement<>(10);
        s.add(3);
        s.add(4);
        assertEquals(0, s.getIndex(10));
        assertEquals(1, s.getIndex(3));
        assertEquals(2, s.getIndex(4));
        assertFalse(s.getIndex(4) != 2);
    }

    @Test
    void contains() {
        MyListElement<Integer> s = new MyListElement<>(10);
        s.add(3);
        s.add(4);
        assertTrue(s.contains(10));
        assertTrue(s.contains(3));
        assertTrue(s.contains(4));
        assertFalse(s.contains(19));
    }

    @Test
    void hasNext() {
        MyListElement<Integer> s = new MyListElement<>(10);
        s.add(3);
        s.add(4);
        assertTrue(s.hasNext());
        assertTrue(s.getNext().hasNext());
        assertFalse(s.getNext().getNext().hasNext());
    }

    @Test
    void clear() {
        MyListElement<Integer> s = new MyListElement<>(10);
        s.add(3);
        s.add(4);
        assertNotNull(s.getElement());
        assertNotNull(s.getNext());
        s.clear();
        assertNull(s.getElement());
        assertNull(s.getNext());
    }

    @Test
    void addAll() {
        MyListElement<Integer> s = new MyListElement<>(10);
        s.add(3);
        s.add(4);
        MyListElement<Integer> s1 = new MyListElement<>(10);
        s1.add(3);
        s1.add(4);
        assertTrue(s.addAll(s1));
        assertTrue(s.addAll(s1));
        assertEquals(10, (int) s.get(0));
        assertEquals(10, (int) s.get(3));
        assertEquals(4, (int) s.get(5));
        assertEquals(3, (int) s.get(1));
        assertEquals(3, (int) s.get(4));
        assertEquals(4, (int) s.get(2));
    }

    @Test
    void testAddAll() {
        MyListElement<Integer> s = new MyListElement<>(10);
        s.add(3);
        s.add(4);
        Collection<Integer> l = new ArrayList<>(3);
        l.add(10);
        l.add(3);
        l.add(4);
        assertTrue(s.addAll(l));
        assertTrue(s.addAll(l));
        assertTrue(s.addAll(l));
        assertEquals(10, (int) s.get(0));
        assertEquals(10, (int) s.get(3));
        assertEquals(10, (int) s.get(6));
        assertEquals(3, (int) s.get(1));
        assertEquals(3, (int) s.get(4));
        assertEquals(3, (int) s.get(7));
        assertEquals(4, (int) s.get(2));
        assertEquals(4, (int) s.get(5));
        assertEquals(4, (int) s.get(8));
    }
}