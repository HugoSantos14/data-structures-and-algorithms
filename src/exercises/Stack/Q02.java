package exercises.Stack;

// Implemente um método em Java que receba uma pilha de
// caracteres e retorne uma nova pilha contendo os caracteres em
// ordem alfabética crescente.

import structures.Node;
import structures.Stack;

// INCOMPLETO
public class Q02 {

    private static Stack<Character> alphabeticOrder(Stack<Character> stack) {
        final Stack<Character> ordered = new Stack<>(stack.getCapacity());
        final Stack<Character> temp = new Stack<>(stack.getCapacity());
        Node<Character> current = stack.getHead();

        for (int i = 0; i < stack.size(); i++) {
            while (!stack.isEmpty()) {
                if (current.getData().compareTo(stack.peek()) < 0) {
                    current = stack.getHead();
                }
                temp.push(stack.pop());
            }

            while (!temp.isEmpty()) {
                if (current.getData().equals(temp.peek())) {
                    ordered.push(temp.pop());
                } else {
                    stack.push(temp.pop());
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

        System.out.println(alphabeticOrder(stack));
    }
}
