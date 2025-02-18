public class LinkedList {
    Node head;

    public LinkedList() {
    }

    public void insertOnHead(String data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }
    
    public void insertOnFinal(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
