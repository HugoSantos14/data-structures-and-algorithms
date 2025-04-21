package exercises.Queue;

// Implemente um método em Java que receba uma fila de inteiros e
// retorne uma fila contendo apenas os números ímpares da fila
// original, na mesma ordem.

import datastructures.Queue;

public class Q01 {

    private static Queue<Integer> oddNumbers(Queue<Integer> q) {
        final Queue<Integer> oddNumbers = new Queue<>();
        final Queue<Integer> temp = new Queue<>();

        while (!q.isEmpty()) {
            int odd = q.getFirst();
            if (odd % 2 != 0) {
                oddNumbers.enqueue(odd);
            }
            temp.enqueue(q.dequeue());
        }

        while (!temp.isEmpty()) {
            q.enqueue(temp.dequeue());
        }

        return oddNumbers;
    }

    public static void main(String[] args) {

        Queue<Integer> q = new Queue<>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        System.out.println(oddNumbers(q));
        System.out.println(q);
    }
}
