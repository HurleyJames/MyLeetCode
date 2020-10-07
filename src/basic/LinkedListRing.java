package basic;

public class LinkedListRing {
    /**
     * 判断单链表是否有环
     * 使用快慢指针法
     * 如果后面一直走到fast指针为空，则无环；
     * 如果走到fast指针与slow指针相等，则有环；
     *
     * @param lNode
     * @return
     */
    public static boolean hasRing(LNode lNode) {
        if (lNode == null) {
            return false;
        }
        if (lNode.next == null) {
            return false;
        }
        LNode p = lNode.next;
        LNode q = lNode.next.next;
        while (q != null) {
            if (p == q) {
                return true;
            }
            p = p.next;
            q = q.next.next;
        }
        return false;
    }

    /**
     * 寻找入口节点
     *
     * @param lNode
     * @return
     */
    public static LNode searchEntryNode(LNode lNode) {
        // 当单链表为空时，单链表没有环
        if (lNode == null) {
            return null;
        }
        // 当当链表只有头节点，且next为空时，说明只有一个节点，也没有环
        if (lNode.next == null) {
            return null;
        }
        // 慢指针
        LNode p = lNode.next;
        // 快指针
        LNode q = lNode.next.next;
        while (q != null) {
            if (q == p) {
                // 如果q与p相等了，说明单链表有环
                break;
            }
            p = p.next;
            q = q.next.next;
        }
        // 如果q为空了，则说明单链表没有环
        if (q == null) {
            return null;
        }

        q = lNode;
        while (q != null) {
            if (p == q) {
                // 入口节点
                return p;
            }
            // 设置它们以相同的步伐1向后推，第一次相遇的时候就是入口节点
            p = p.next;
            q = q.next;
        }
        return null;
    }

    /**
     * 返回环的长度
     *
     * @param lNode
     * @return
     */
    public static int ringLength(LNode lNode) {
        // 首先，找到环的入口节点
        LNode p = searchEntryNode(lNode);
        if (p == null) {
            return 0;
        }
        LNode q = p.next;
        int length = 1;
        while (p != q) {
            length++;
            // 入口节点往后一圈，当再次回到入口节点时，走过的路程就是环的长度
            q = q.next;
        }
        // 返回环的长度
        return length;
    }
}

/**
 * 定义单链表的节点类
 */
class LNode {
    /**
     * 为了简化访问单链表，节点中的数据项的访问权限都设为public
     */
    int data;
    LNode next;
}
