package basic.ReverseLinkedList;

public class Node {

    /**
     * 数据域
     */
    private int data;
    /**
     * 指针域
     */
    private Node next;

    public Node(int data) {
        // super();
        this.data = data;
    }

    public int getdata() {
        return data;
    }

    public void setdata(int data) {
        this.data = data;
    }

    public Node getnext() {
        return next;
    }

    public void setnext(Node next) {
        this.next = next;
    }

}
