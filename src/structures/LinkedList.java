package structures;

public class LinkedList<E> {
    
    private Node<E> head;
    private int size;
    
    public LinkedList() {
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

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Lista vazia";
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

    public void add(E data) {
        final Node<E> newNode = new Node<E>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }
    
    public void addOnFinal(E data) {
        final Node<E> newNode = new Node<E>(data);
        
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<E> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        size++;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("List is Empty");
        } else {
            head = head.getNext(); //Eu retiro a ligação com a antiga cabeça, fazendo a próxima ser a nova cabeça! Assim retirando a ligação dele a lista
            size--;
        }
    }
    
    public void remove(E data) {
        if (isEmpty()) {
            System.out.println("Não há nós nessa lista.");
            return;
        } 
        if (head.getData() == data) {
            head = head.getNext();
            System.out.println("O primeiro elemento foi removido.");
            return;
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
            size--;
        }
    }
}
