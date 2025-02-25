package exercises.months;

import structures.Stack;

public class Q04 {
    public static void main(String[] args) {
        
        Stack<String> stack = new Stack(12);

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

        stack.peekMonths();
    }
}
