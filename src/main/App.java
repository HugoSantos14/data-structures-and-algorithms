package main;

import structures.Queue;

public class App {
    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.removeHead();

        System.out.println(queue);
    }
}
