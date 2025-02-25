package structures;

public class Node2 {

    private String data;
    private Node2 next;
    private Node2 prev;

    public Node2(String data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }

    public Node2 getPrev() {
        return prev;
    }

    public void setPrev(Node2 prev) {
        this.prev = prev;
    }
}
