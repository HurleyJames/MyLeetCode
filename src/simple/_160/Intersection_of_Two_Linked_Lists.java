package simple._160;

import medium._002.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        方法一
//        // 如果某个链表为空，是肯定不会相交的
//        if (headA == null || headB == null) {
//            return null;
//        }
//        while (headA != null) {
//            ListNode newHead = headB;
//            while (newHead != null) {
//                // 如果相等，就找到了相交点
//                if (headA == newHead) {
//                    return newHead;
//                } else {
//                    newHead = newHead.next;
//                }
//            }
//            headA = headA.next;
//        }
//        // 如果遍历完了都没有找到，说明没有相交点
//        return null;

//        // 方法二
//        Set s = new HashSet();
//        while (headA != null) {
//            s.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null) {
//            if (s.contains(headB)) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;

//        // 方法三
//        ListNode a = headA;
//        ListNode b = headB;
//        while (a != b) {
//            if (a != null) {
//                // 继续遍历链表A
//                a = a.next;
//            } else {
//                // 去遍历链表B，从头结点开始
//                a = headB;
//            }
//
//            if (b != null) {
//                // 继续遍历链表B
//                b = b.next;
//            } else {
//                // 去遍历链表A，从头节点开始
//                b = headA;
//            }
//        }
//        return a;
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
