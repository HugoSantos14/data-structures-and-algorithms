package structures;

public class Stack<E> {

    private Node<E> head;
    private int size;
    private int amount;
    
    public Stack(int size) {
        this.head = null;
        this.size = size;
    }

    public void push(E data) {

        Node<E> temp = new Node<E>(data);
     
        if(amount >= size) {
            System.out.println("A pilha está cheia 2");
        } else {
            temp.setNext(temp);
            head = temp;
            amount++;
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
    
    public void peekMonths() {

        Node<String> current = (Node<String>) head;

        if (head == null) {
            System.out.println("Não há elementos na pilha");
        } else {
            while (current != null) {
                if (current.getData().length() > 5) {
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

        if (head == null) {
            return;
        }

        Node<E> temp = head;
        head = head.getNext();
        temp.setNext(null);
        amount--;
    }

    public void isEmpty() {

        if (head == null) {
            System.out.println("A pilha está vazia");
        } else {
            System.out.println("A pilha não está vazia");
        }
    }

    public void isFull() {

        if (size == amount) {
            System.out.println("A pilha está cheia");
        } else {
            System.out.println("A pilha não está cheia");
        }
    }
}
