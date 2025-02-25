package structures;

public class LinkedList<E> {
    
    private Node<E> head;
    
    public LinkedList() {
    }
    
    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public void add(E data) {

        Node<E> newNode = new Node<E>(data);
        newNode.setNext(head);
        head = newNode;
    }
    
    public void addOnFinal(E data) {

        Node<E> newNode = new Node<E>(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node<E> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }
    
    public void print() {
        
        Node<E> current = head;
        
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

        Node<E> current = head; //Vai receber a lista e sempre vai para baixo, onde não é para a cima é para baixo
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public void Pop() {
        if (head == null) {
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
    
    public boolean remove(E data) {

        if (head == null) {
            System.out.println("Não há nós nessa lista.");
            return false;
        } 
        if (head.getData() == data) {
            head = head.getNext();
            System.out.println("O primeiro elemento foi removido.");
            return true;
        }
        
        Node<E> temp = head;
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
