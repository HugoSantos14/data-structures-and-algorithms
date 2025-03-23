package main;

import exercises.oldestBook.Book;
import structures.*;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        Map<Book, Double> stock = new HashMap<>();

        Book b1 = new Book("Book 1", "Author 1");
        Book b2 = new Book("Book 2", "Author 2");
        Book b3 = new Book("Book 3", "Author 3");

        stock.put(b1, 100.0);
        stock.put(b2, 200.0);
        stock.put(b3, 150.0);

        Book b4 = new Book("Book 1", "Author 1");

        System.out.println("Contais 'b4' key: " + stock.containsKey(b4));
    }
}
