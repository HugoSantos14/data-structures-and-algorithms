package main;

import structures.DoublyLinkedList;
import structures.Queue;

public class App {
    public static void main(String[] args) {

        try {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

            list.addFirst(1);
            list.addFirst(2);
            list.addFirst(3);
            list.addFirst(4);
            list.addFirst(5);
            list.add(6, -1);

            list.printByTail();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
