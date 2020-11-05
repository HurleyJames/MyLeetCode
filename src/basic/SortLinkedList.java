package basic;

/**
 * 单链表排序
 */
public class SortLinkedList {

    public static void main(String[] args) {
        // 测试数据
        Node head = new Node(0);
        Node node1 = new Node(4);
        Node node2 = new Node(3);
        Node node3 = new Node(1);
        Node node4 = new Node(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node h = head;
        sortLinkedList(head);

        // 打印反转后的链表
        while (h != null) {
            System.out.print(h.val + ", ");
            h = h.next;
        }
    }

    /**
     * 单链表排序
     *
     * @param head
     * @return
     */
    public static Node sortLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 头节点
        Node pre = head;
        Node cur = head.next;
        // 辅助节点
        Node aux = new Node(0);
        // 辅助节点永远指向头节点
        aux.next = head;
        while (cur != null) {
            // 如果cur节点的值比前一节点的值小
            if (cur.val < pre.val) {
                // 前一节点直接跳过cur，指向cur的后一节点
                pre.next = cur.next;
                Node node1 = aux;
                Node node2 = aux.next;
                // 遍历，找到一个节点的值要比cur更小的节点
                while (cur.val > node2.val) {
                    node1 = node2;
                    node2 = node2.next;
                }
                // 找到后，就将这两个值排序
                node1.next = cur;
                cur.next = node2;
                cur = pre.next;
            } else {
                // 往后移动，接着查找
                pre = cur;
                cur = cur.next;
            }
        }
        return aux.next;
    }

}

/**
 * 节点类
 */
class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
