package datastructures;

public class Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public Queue() {
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Fila vazia";
        }

        StringBuilder result = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            result.append(current.getData());
            if (current.getNext() != null) {
                result.append(", ");
            }
            current = current.getNext();
        }

        return result.toString();
    }

    public void add(E data) {
        final Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public E remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("A fila está vazia");
        }

        E removedData = head.getData();
        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }

        return removedData;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Fila vazia");
        }
        return head.getData();
    }
}
