package exercises.DoublyLinkedList;

import structures.DoublyLinkedList;

public class Q01 {
    public static void main(String[] args) {
        
        final DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.addLast("January");
        list.addLast("February");
        list.addLast("March");
        list.addLast("April");
        list.addLast("May");
        list.addLast("June");
        list.addLast("July");
        list.addLast("August");
        list.addLast("September");
        list.addLast("October");
        list.addLast("November");
        list.addLast("December");

        list.deleteMonths();
        list.print();
    }
}
