package structures;

public class DoublyLinkedList {
    
    private Node2 head;
    private Node2 tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node2 getHead() {
        return head;
    }

    public void setHead(Node2 head) {
        this.head = head;
    }

    public Node2 getTail() {
        return tail;
    }

    public void setTail(Node2 tail) {
        this.tail = tail;
    }

    public void add(String data) {
        Node2 temp = new Node2(data);
        
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
        }
    }

    public void addOnFinal(String data) {
        Node2 temp = new Node2(data);

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
        Node2 current = head;

        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public void printByTail() {
        Node2 current = tail;

        while (current != null) {
            System.out.println(current.getData());
            current = current.getPrev();
        }
    }
}
