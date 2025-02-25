package exercises.oldestBook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        list.add(new Book("livro1", "autor1", LocalDate.parse("24/02/2025", dtf)));
        list.add(new Book("livro2", "autor2", LocalDate.parse("23/02/2025", dtf)));
        list.add(new Book("livro3", "autor3", LocalDate.parse("22/02/2025", dtf)));

        System.out.println("LIVRO MAIS ANTIGO:");
        System.out.println(list.getOldestBook());
    }
}
