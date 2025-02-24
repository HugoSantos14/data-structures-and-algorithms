import structures.LinkedList;

public class App {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.add("1");   
        list.add("2");   
        list.add("3");

        list.print();

        list.remove("1");
        System.out.println();

        list.print();
        System.out.println(list.getHead().getData());
    }
}
