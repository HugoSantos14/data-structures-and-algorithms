package exercises.Queue;

// Implemente um método em Java que receba uma fila de inteiros e
// retorne uma fila contendo apenas os números ímpares da fila
// original, na mesma ordem.

import datastructures.Queue;

public class Q01 {

    private static Queue<Integer> oddNumbers(Queue<Integer> q) {
        final Queue<Integer> oddNumbers = new Queue<>(q.getCapacity());
        final Queue<Integer> temp = new Queue<>(q.getCapacity());

        while (!q.isEmpty()) {
            int odd = q.peek();
            if (q.peek() % 2 != 0) {
                oddNumbers.add(odd);
            }
            temp.add(q.remove());
        }

        while (!temp.isEmpty()) {
            q.add(temp.remove());
        }

        return oddNumbers;
    }

    public static void main(String[] args) {

        Queue<Integer> q = new Queue<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(oddNumbers(q));
        System.out.println(q);
    }
}
