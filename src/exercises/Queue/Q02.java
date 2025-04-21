package exercises.Queue;

// Implemente um método em Java que receba uma fila de inteiros e
// retorne a média dos elementos da fila.

import datastructures.Queue;

public class Q02 {

    private static double average(Queue<Integer> q) {
        final Queue<Integer> temp = new Queue<>();
        double avg = 0;

        while (!q.isEmpty()) {
            avg += q.getFirst();
            temp.enqueue(q.dequeue());
        }

        while (!temp.isEmpty()) {
            q.enqueue(temp.dequeue());
        }

        return avg / q.size();
    }

    public static void main(String[] args) {

        Queue<Integer> q = new Queue<>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        System.out.println(q);
        System.out.println(average(q));
    }
}
