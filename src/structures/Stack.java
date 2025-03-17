package structures;

import exceptions.StackException;

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
                result.append(", ");
            }
            current = current.getNext();
        }

        return result.toString();
    }

    public void push(E data) {
        if (isFull()) {
            throw new StackException("A pilha está cheia");
        }

        final Node<E> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void pop() {
        if (isEmpty()) {
            throw new StackException("A pilha está vazia");
        }

        final Node<E> current = head;
        head = head.getNext();
        size--;
    }

    public void pop(E data) {
        if (isEmpty()) {
            throw new StackException("A pilha está vazia");
        }
        if (head.getData() == data) {
            pop();
            return;
        }

        final Stack<E> temp = new Stack<>(capacity);
        Node<E> current = head;
        while (current.getData() != data) {
            temp.push(head.getData());
            pop();
            current = current.getNext();
        }
        pop();

        while (!temp.isEmpty()) {
            push(temp.getHead().getData());
            temp.pop();
        }
        size--;
    }

    public Node<E> peek() {
        if (isEmpty()) {
            return null;
        }
        return head;
    }
}
