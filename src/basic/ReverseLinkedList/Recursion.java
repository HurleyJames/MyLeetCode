package basic.ReverseLinkedList;

/**
 * 递归法反转链表
 */
public class Recursion {

    public static void main(String[] args) {
        // 初始化链表结构与数据
        Node head = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        head.setnext(n1);
        n1.setnext(n2);
        n2.setnext(n3);

        Node h = head;
        // 打印反转前的链表
        while (h != null) {
            System.out.println(h.getdata() + ", ");
            h = h.getnext();
        }

        System.out.print("\n");

        // 开始反转链表
        head = reverseByRecursion(head);

        // 打印反转后的链表
        while (head != null) {
            System.out.println(head.getdata() + ", ");
            head = head.getnext();
        }
    }

    public static Node reverseByRecursion(Node head) {
        // head是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getnext() == null) {
            // 若头节点为空说明是空链，若位于尾节点，则直接返回
            return head;
        }
        // 先反转后续节点head.getNext()
        Node reHead = reverseByRecursion(head.getnext());
        // 将当前节点的指针指向前一个节点
        head.getnext().setnext(head);
        // 将后一节点的指针域设置为null
        head.setnext(null);
        // 返回反转后的新节点
        return reHead;
    }
}

