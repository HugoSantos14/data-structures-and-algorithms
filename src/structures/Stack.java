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

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= capacity;
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

    public void peek() {

        Node<E> current = head;

        if (head == null) {
            System.out.println("Não há elementos na pilha");
        } else {
            System.out.println(current.getData());
        }
    }
    
    // Exercício
    public void peekMonths() {

        Node<E> current = head;

        if (head == null) {
            System.out.println("Não há elementos na pilha");
        } else {
            while (current != null) {
                if (current.getData().toString().length() > 5) {
                    System.out.println(current.getData());
                }
                current = current.getNext();
            }
        }
    }
    
    public void peekAll() {

        Node<E> current = head;

        if (head == null) {
            System.out.println("Não há elementos na pilha");
        } else {
            while (current != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }
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
}
