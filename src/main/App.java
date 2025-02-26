package main;

import structures.DoublyLinkedList;

public class App {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.print();
        list.printByTail();
    }
}
