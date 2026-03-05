package opgave01.models;

public class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }
}
