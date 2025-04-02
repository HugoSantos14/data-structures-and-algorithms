package exercises.Stack;

// Implemente um método em Java que receba uma pilha de
// caracteres e retorne uma nova pilha contendo os caracteres em
// ordem alfabética crescente.

import datastructures.Stack;

public class Q02 {

    private static Stack<Character> alphabeticOrder(Stack<Character> stack) {
        final Stack<Character> ordered = new Stack<>(stack.getCapacity());
        final Stack<Character> temp = new Stack<>(stack.getCapacity());

        while (!stack.isEmpty()) {
            Character minChar = stack.peek();
            while (!stack.isEmpty()) {
                Character current = stack.pop();
                if (current.compareTo(minChar) < 0) {
                    minChar = current;
                }
                temp.push(current);
            }

            ordered.push(minChar);
            boolean removed = false;
            while (!temp.isEmpty()) {
                Character current = temp.pop();
                if (current.equals(minChar) && !removed) {
                    removed = true;
                } else {
                    stack.push(current);
                }
            }
        }

        return ordered;
    }

    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();

        stack.push('e');
        stack.push('c');
        stack.push('d');
        stack.push('a');
        stack.push('b');

        System.out.println(stack);
        System.out.println(alphabeticOrder(stack));
    }
}
