package datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class LinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {
    }

    public LinkedList(Collection<? extends E> c) {
        this();
        if (c != null) {
            for (E element : c) {
                add(element);
            }
        }
    }

    public E getFirst() {
        if (isEmpty()) throw new NoSuchElementException("Lista vazia");
        return head.data;
    }

    public E getLast() {
        if (isEmpty()) throw new NoSuchElementException("Lista vazia");
        return tail.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Lista vazia";
        }

        StringBuilder result = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }

        return result.toString();
    }

    public void addFirst(E data) {
        final Node<E> newNode = new Node<>(data);

        if (head == null) {
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    public void add(E data) {
        final Node<E> newNode = new Node<>(data);

        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public void add(E data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " não encontrado");
        } else if (index == 0) {
            addFirst(data);
            return;
        } else if (index == size - 1) {
            add(data);
            return;
        }

        Node<E> current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        assert current != null;
        final Node<E> newNode = new Node<>(data);
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<E> temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<E> temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        size--;
    }

    public void remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        } else if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " não encontrado");
        } else if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }

        Node<E> current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        assert current != null;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
        size--;
    }

    public void removeIf(Predicate<? super E> filter) {
        if (filter == null) {
            throw new NullPointerException("O predicado não pode ser nulo");
        }

        Node<E> current = head;
        while (current != null) {
            Node<E> next = current.next;
            if (filter.test(current.data)) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
            }
            current = next;
        }
    }

    public E get(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        } else if (index > size - 1 || index < 0 ) {
            throw new IndexOutOfBoundsException("Index " + index + " não encontrado");
        } else if (index == 0) {
            return head.data;
        } else if (index == size - 1) {
            return tail.data;
        }

        Node<E> current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        assert current != null;
        return current.data;
    }

    public int indexOf(E data) {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        }

        int count = 0;
        Node<E> current = head;
        while (current != null && !current.data.equals(data)) {
            current = current.next;
            count++;
        }
        return count;
    }

    public boolean contains(E data) {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        }

        Node<E> current = head;
        while (current != null && !current.data.equals(data)) {
            current = current.next;
        }

        return current != null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Lista vazia");
            }
            final E data = current.data;
            current = current.next;
            return data;
        }
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;
        
        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
