package exercises.DoublyLinkedList;

import structures.DoublyLinkedList;
import structures.Node;

public class Q01 {

    private static <E> void deleteMonths(DoublyLinkedList<E> list) {
        Node<E> current = list.getHead();

        while (current != null) {
            Node<E> nextNode = current.getNext();

            if (current.getData().toString().length() < 5) {
                if (current == list.getHead()) {
                    list.deleteFirst();
                } else if (current == list.getTail()) {
                    list.deleteLast();
                } else {
                    current.getPrev().setNext(current.getNext()); // O nó anterior aponta para o próximo nó
                    current.getNext().setPrev(current.getPrev()); // O próximo nó aponta para o nó anterior

                    // Desconecta o nó removido da lista
                    current.setPrev(null);
                    current.setNext(null);
                    list.setSize(list.size()-1);
                }
            }

            current = nextNode;
        }
    }

    public static void main(String[] args) {
        
        final DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.addLast("January");
        list.addLast("February");
        list.addLast("March");
        list.addLast("April");
        list.addLast("May");
        list.addLast("June");
        list.addLast("July");
        list.addLast("August");
        list.addLast("September");
        list.addLast("October");
        list.addLast("November");
        list.addLast("December");

        deleteMonths(list);
        System.out.println(list);
    }
}
