package simple._206;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class Reverse_Linked_List {

    public ListNode reverseList(ListNode head) {
//        // 方法一：递归
//        // 如果头结点为空，或者只有一个头结点，那么翻转过来就是头结点本身
//        // 终止条件是，当前节点或者下一个节点为 null
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode p = reverseList(head.next);
//        // 改变节点的指向
//        head.next.next = head;
//        head.next = null;
//        return p;


        // 方法二：迭代
        // 申请节点，pre 和 curr，pre 指向 null
        ListNode prev = null;
        ListNode curr = head;
        ListNode tmp = null;
        while (curr != null) {
            // 记录当前节点的下一个节点
            tmp = curr.next;
            // 然后将当前节点指向 pre
            curr.next = prev;
            // pre 和 curr 节点都前进一位
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
