package exercises.DoublyLinkedList;

import datastructures.LinkedList;
import datastructures.Node;

public class Q01 {

    private static <E> void deleteMonths(LinkedList<E> list) {
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
        
        final LinkedList<String> list = new LinkedList<>();

        list.add("January");
        list.add("February");
        list.add("March");
        list.add("April");
        list.add("May");
        list.add("June");
        list.add("July");
        list.add("August");
        list.add("September");
        list.add("October");
        list.add("November");
        list.add("December");

        deleteMonths(list);
        System.out.println(list);
    }
}
