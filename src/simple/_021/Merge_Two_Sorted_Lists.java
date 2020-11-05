package simple._021;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 1.递归法
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            // 如果 l1 的 val 更小，则将 l1.next 等于排序好的链表头
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            // 如果 l2 的 val 更小，则将 l2.next 等于排序号的链表头
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoList2(ListNode l1, ListNode l2) {
        // 2.迭代法
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 == null) {
            prev.next = l2;
        } else {
            prev.next = l1;
        }

        return prehead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
