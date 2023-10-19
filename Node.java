public class Node {
    Song data;
    Node next;
    Node prev;

    public Node(Song data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Song getData() {
        return data;
    }

    public void setData(Song data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
