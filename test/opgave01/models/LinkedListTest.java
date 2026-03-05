package opgave01.models;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void testAddAndSize() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testAddFirst() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("A");
        list.addFirst("B");
        assertEquals("B", list.getFirst());
        assertEquals("A", list.get(1));
    }

    @Test
    void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        Integer integer = 20;
        assertTrue(list.remove(integer));
        assertFalse(list.contains(20));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.removeFirst();
        assertEquals(20, list.getFirst());
        assertEquals(1, list.size());
    }

    @Test
    void testIndexOf() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        assertEquals(1, list.indexOf("Banana"));
        assertEquals(-1, list.indexOf("Durian"));
    }

    @Test
    void testIterator() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        list.add(42);
        assertFalse(list.isEmpty());
    }

    @Test
    void testClear() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
}