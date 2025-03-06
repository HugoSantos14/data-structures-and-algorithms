package structures;

public class Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int capacity;
    private boolean full;

    public Queue() {
        capacity = Integer.MAX_VALUE;
    }

    public Queue(int capacity) {
        this.capacity = capacity;
    }

    public Node<E> peek() {
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        full = size >= capacity;
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
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
        if (isFull()) {
            return;
        }

        final Node<E> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void removeHead() {
        if (isEmpty()) {
            return;
        }

        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }
    }
}
