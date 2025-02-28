package exercises.DoublyLinkedList;

import exercises.oldestBook.Book;
import structures.DoublyLinkedList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Q03 {
    public static void main(String[] args) {

        final DoublyLinkedList<Book> books = new DoublyLinkedList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        books.addFirst(new Book("livro1", "autor1", LocalDate.parse("02/08/2021", dtf)));
        books.addFirst(new Book("livro2", "autor2", LocalDate.parse("07/05/2023", dtf)));
        books.addFirst(new Book("livro3", "autor3", LocalDate.parse("24/01/2022", dtf)));
        books.addFirst(new Book("livro4", "autor4", LocalDate.parse("27/02/2025", dtf)));
        books.addFirst(new Book("livro5", "autor5", LocalDate.parse("19/11/2024", dtf)));
    }
}
