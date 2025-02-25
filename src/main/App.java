package main;

import structures.DoublyLinkedList;

public class App {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.add("1");
        list.add("2");
        list.add("3");

        list.print();
        System.out.println();
        list.printByTail();
    }
}
