package exercises.oldestBook;

public class LinkedList {
    
    private Node head;

    public LinkedList() {
    }

    public void add(Book book) {

        Node newNode = new Node(book);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public Book getOldestBook() {
        if (head == null) {
            return null;
        }

        Node temp = head;
        Book oldestBook = head.getData();

        while (temp != null) {
            if (temp.getData().getPublicationDate().isBefore(oldestBook.getPublicationDate())) {
                oldestBook = temp.getData();
            }
            temp = temp.getNext();
        }

        return oldestBook;
    }
}
