package exercises.DoublyLinkedList;

import exercises.oldestBook.Book;
import structures.DoublyLinkedList;
import structures.Node;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Q03 {

    private static void bubbleSort(DoublyLinkedList<Book> list) {
        final int size = list.size();
        Node<Book> current = list.getHead();
        Node<Book> next = current.getNext();

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (current.getData().getPublicationDate().isAfter(next.getData().getPublicationDate())) {
                    list.setHead(list.getHead().getNext());
                    list.setHead(current);
                }
            }
        }
    }

    public static void main(String[] args) {

        final DoublyLinkedList<Book> books = new DoublyLinkedList<>();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        books.addFirst(new Book("livro1", "autor1", LocalDate.parse("02/08/2021", dtf)));
        books.addFirst(new Book("livro2", "autor2", LocalDate.parse("07/05/2023", dtf)));
        books.addFirst(new Book("livro3", "autor3", LocalDate.parse("24/01/2022", dtf)));
        books.addFirst(new Book("livro4", "autor4", LocalDate.parse("27/02/2025", dtf)));
        books.addFirst(new Book("livro5", "autor5", LocalDate.parse("19/11/2024", dtf)));

        bubbleSort(books);

        // livro1, livro3, livro2, livro5, livro4
        System.out.println(books);
    }
}
