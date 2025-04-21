package exercises.months;

import datastructures.Stack;

import java.time.Month;

public class Q04 {

    private static <E> void peekMonths(Stack<E> stack) {

//        Node<E> current = stack.getHead();
//
//        if (stack.isEmpty()) {
//            System.out.println("Não há elementos na pilha");
//        } else {
//            while (current != null) {
//                if (current.getData().toString().length() > 5) {
//                    System.out.println(current.getData());
//                }
//                current = current.getNext();
//            }
//        }

        for (E element : stack) {
            if (element.toString().length() > 5) {
                System.out.println(element);
            }
        }
    }

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>(12);

        stack.push("Janeiro");
        stack.push("Fevereiro");
        stack.push("Março");
        stack.push("Abril");
        stack.push("Maio");
        stack.push("Junho");
        stack.push("Julho");
        stack.push("Agosto");
        stack.push("Setembro");
        stack.push("Outubro");
        stack.push("Novembro");
        stack.push("Dezembro");

        peekMonths(stack);
    }
}
