package opgave01.models;

import java.util.Iterator;

public class LinkedList<E> implements ListEaaa<E> {
    private Node<E> head;
    private Node<E> tail;

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
            tail = null;
        } else if (tail == null) {
            head.next = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public boolean remove(E e) {
        if (head == null) return false;

        if (head.data.equals(e)) {
            head = head.next;
            if (head == null) tail = null;
            return true;
        }

        Node<E> current = head;
        while (current.next != null && !current.next.data.equals(e)) {
            current = current.next;
        }

        if (current.next != null) {
            if (current.next == tail) tail = current;
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        if (tail == null) tail = head;
    }

    @Override
    public E getFirst() {
        return head.data;
    }

    @Override
    public void removeFirst() {
        head = head.next;
        if (head == null || head.next == null) tail = null;
    }

    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(e)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        int count = 0;
        Node<E> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        return getRecursive(head, index);
    }

    private E getRecursive(Node<E> node, int index) {
        if (index == 0) return node.data;
        return getRecursive(node.next, index - 1);
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(e);
            return;
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node<E> newNode = new Node<>(e);
        newNode.next = current.next;
        current.next = newNode;
        if (newNode.next == null) tail = newNode;

    }

    @Override
    public E remove(int index) {
        if (index == 0) {
            E data = head.data;
            removeFirst();
            return data;
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        E data = current.next.data;
        current.next = current.next.next;
        if (current.next == null) tail = current;
        return data;
    }

    @Override
    public int indexOf(E e) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(e)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
