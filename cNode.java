public class cNode {
    Cache data;
    cNode next;
    cNode prev;

    public cNode(Cache data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Cache getData() {
        return data;
    }

    public void setData(Cache data) {
        this.data = data;
    }

    public cNode getNext() {
        return next;
    }

    public void setNext(cNode next) {
        this.next = next;
    }

    public cNode getPrev() {
        return prev;
    }

    public void setPrev(cNode prev) {
        this.prev = prev;
    }
}
