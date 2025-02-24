package structures;

public class LinkedList {
    
    Node head;
    
    public LinkedList() {
    }
    
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void add(String data) {

        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }
    
    public void addOnFinal(String data) {

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
    
    public void print() {
        
        Node current = head;
        
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }

        System.out.println();
    }

    public void Peek() {
        System.out.println(head.getData());
    }

    public void PeekAll() {

        Node current = head; //Vai receber a lista e sempre vai para baixo, onde não é para a cima é para baixo
        while(current != null) {
        
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public void Pop() {

        if(head == null) {
            System.out.println("List is Empty");
        } else {
            head = head.getNext(); //Eu retiro a ligação com a antiga cabeça, fazendo a próxima ser a nova cabeça! Assim retirando a ligação dele a lista
        }
    }

    public void isEmpty() {

        if(head == null) {
            System.out.println("List is Empty");
        } else {
            System.out.println("List is not empty");
        }
    }
    
    public boolean remove(String data) {

        if (head == null) {
            System.out.println("Não há nós nessa lista.");
            return false;
        } 
        if (head.getData() == data) {
            head = head.getNext();
            System.out.println("O primeiro elemento foi removido.");
            return true;
        }
        
        Node temp = head;
        while (temp.getNext() != null && temp.getNext().getData() != data) {
            temp = temp.getNext();
        }
        if (temp.getNext() == null) {
            System.out.println("O elemento buscado não consta na lista.");    
        } else {
            System.out.println("O elemento " + temp.getNext().getData() + " foi removido.");
            temp.setNext(temp.getNext().getNext());
            return true;
        }

        return true;
    }
}
