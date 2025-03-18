package main;

import exceptions.StackException;
import structures.DoublyLinkedList;
import structures.Queue;
import structures.Stack;

public class App {
    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();

        queue.add(1);
        queue.add(2);
//        queue.add(3);
//        queue.add(4);
//        queue.add(5);

        System.out.println(queue.remove());
        System.out.println(queue.getHead());
        System.out.println(queue.getTail());
    }
}
