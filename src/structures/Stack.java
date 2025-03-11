package structures;

public class Stack<E> {

    private Node<E> head;
    private int size;
    private final int capacity;

    public Stack() {
        capacity = Integer.MAX_VALUE;
    }

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
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

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Pilha vazia";
        }

        StringBuilder result = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            result.append(current.getData());
            if (current.getNext() != null) {
                current = current.getNext();
            }
            current = current.getNext();
        }

        return result.toString();
    }

    public void push(E data) {

        Node<E> temp = new Node<E>(data);
     
        if (isFull()) {
            System.out.println("A pilha está cheia 2");
        } else {
            temp.setNext(temp);
            head = temp;
            size++;
        }
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }

        Node<E> temp = head;
        head = head.getNext();
        temp.setNext(null);
        size--;
    }

    public Node<E> top() {
        if (isEmpty()) {
            return null;
        }
        return head;
    }
}
