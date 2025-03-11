package main;

import structures.DoublyLinkedList;
import structures.Queue;

public class App {
    public static void main(String[] args) {
        try {
            final DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

            list.addLast(1);
            list.addLast(2);
            list.addLast(3);
            list.addLast(4);
            list.addLast(5);

            list.delete(4);

            System.out.println(list);

        } catch (IndexOutOfBoundsException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
