package structures;

public class DoublyLinkedList<E> {
    
    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList() {
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

    public void addFirst(E data) {
        final Node<E> temp = new Node<E>(data);
        
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
        }
    }

    public void addLast(E data) {
        Node<E> temp = new Node<E>(data);

        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            temp.setNext(temp);
            temp.setPrev(tail);
            tail = temp;
        }
    }

    public void print() {
        Node<E> current = head;

        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void printByTail() {
        Node<E> current = tail;

        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getPrev();
        }
        System.out.println();
    }
}
