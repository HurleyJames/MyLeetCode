package simple._02_03;

public class Delete_Middle_Node {

    public void deleteNode(ListNode node) {
        // 慢指针
        node.val = node.next.val;
        // 快指针
        node.next = node.next.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
