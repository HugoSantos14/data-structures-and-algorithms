package structures;

public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

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
        if (head == null) {
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

    public void addFirst(E data) {
        final Node<E> newNode = new Node<E>(data);
        
        if (isEmpty()) {
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
        }
        head = newNode;
        size++;
    }

    public void addLast(E data) {
        final Node<E> newNode = new Node<E>(data);
        
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public void add(E data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice " + index + " não encontrado");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }

        Node<E> current = head;
        int count = 0;

        //Navega até o nó na posição especificada.
        while (current != null && count != index) {
            current = current.getNext();
            count++;
        }

        final Node<E> newNode = new Node<>(data);
        newNode.setNext(current); // O próximo do novo nó é o nó atual
        newNode.setPrev(current.getPrev()); // O anterior do novo nó é o anterior do nó atual
        current.getPrev().setNext(newNode); // O próximo do nó anterior ao atual é o novo nó
        current.setPrev(newNode); // O anterior do nó atual é o novo nó
        size++;
    }

    public void printByTail() {
        Node<E> current = tail;

        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getPrev();
        }
        System.out.println();
    }
    
    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
            return;
        }

        final Node<E> temp = head;
        head = head.getNext();
        head.setPrev(null);
        temp.setNext(null);
        size--;
    }
    
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
            return;
        }

        final Node<E> temp = tail;
        tail = tail.getPrev();
        tail.setNext(null);
        temp.setPrev(null);
        size--;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice " + index + " não encontrado");
        }
        if (isEmpty()) {
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }

        Node<E> current = head;
        int count = 0;
        
        //Navega até o nó na posição especificada.
        while (current != null && count != index) {
            current = current.getNext();
            count++;
        }
        
        deleteNode(current);
    }
    
    private void deleteNode(Node<E> node) {
        if (node == null) {
            return;
        }

        // Ajusta os ponteiros para remover o nó da lista
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext()); // O nó anterior aponta para o próximo nó
        }
        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev()); // O próximo nó aponta para o nó anterior
        }

        // Desconecta o nó removido da lista
        node.setPrev(null);
        node.setNext(null);
        size--;
    }
}
