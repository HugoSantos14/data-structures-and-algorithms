package exercises.Stack;

// Implemente um método em Java que receba uma pilha de inteiros
// e retorne uma nova pilha contendo os elementos da pilha original
// em ordem reversa.

import datastructures.Stack;

public class Q01 {

    private static <E> Stack<E> reverse(Stack<E> stack) {
        final Stack<E> reversed = new Stack<>();
        while (!stack.isEmpty()) {
            reversed.push(stack.pop());
        }
        return reversed;
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);
        System.out.println(reverse(stack));
    }
}
