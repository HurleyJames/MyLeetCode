package basic.ReverseLinkedList;

/**
 * 遍历法反转链表
 */
public class Traverse {

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
        head = reverseByTraverse(head);

        // 打印反转后的链表
        while (head != null) {
            System.out.println(head.getdata() + ", ");
            head = head.getnext();
        }
    }

    public static Node reverseByTraverse(Node head) {
        if (head == null) {
            return head;
        }
        // pre指向前一个节点
        Node pre = head;
        // cur指向后一个节点
        Node cur = head.getnext();
        // tmp是临时节点，用来储存cur的下一个节点的
        Node tmp;

        while (cur != null) {
            // 用来存储cur的下一个节点
            tmp = cur.getnext();
            // 反转指针的指向
            cur.setnext(pre);

            // 指针都向后移动
            pre = cur;
            cur = tmp;
            // 循环反转
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        // 因为head相当于尾节点了
        head.setnext(null);

        return pre;
    }
}