package exercises.Queue;

// Implemente um método em Java que receba uma fila de inteiros e
// retorne a média dos elementos da fila.

import structures.Queue;

public class Q02 {

    private static double average(Queue<Integer> q) {
        final Queue<Integer> temp = new Queue<>(q.getCapacity());
        double avg = 0;

        while (!q.isEmpty()) {
            avg += q.peek();
            temp.add(q.remove());
        }

        while (!temp.isEmpty()) {
            q.add(temp.remove());
        }

        return avg / q.size();
    }

    public static void main(String[] args) {

        Queue<Integer> q = new Queue<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(q);
        System.out.println(average(q));
    }
}
