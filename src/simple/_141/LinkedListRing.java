package simple._141;

/**
 * 链表是否有环
 */
public class LinkedListRing {
    /**
     * 判断单链表是否有环
     * 使用快慢指针法
     * 如果后面一直走到fast指针为空，则无环；
     * 如果走到fast指针与slow指针相等，则有环；
     *
     * @param head
     * @return
     */
    public static boolean hasRing(LNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        LNode p = head;
        LNode q = head;

        if (q.next != null) {
            q = q.next.next;
        } else {
            return false;
        }
        p = p.next;
        while (q != p) {
            if (q != null && q.next != null) {
                q = q.next.next;
            } else {
                return false;
            }
            p = p.next;
        }
        // 如果相遇，说明有环
        return true;
    }

    /**
     * 寻找入口节点
     *
     * @param head
     * @return
     */
    public static LNode searchEntryNode(LNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        LNode p = head;
        LNode q = head;

        if (q.next != null) {
            q = q.next.next;
        } else {
            return null;
        }
        p = p.next;
        while (q != p) {
            if (q != null && q.next != null) {
                q = q.next.next;
            } else {
                return null;
            }
            p = p.next;
        }

        // 如果相遇，说明有环，寻找入口节点
        while (head != p) {
            p = p.next;
            head = head.next;
        }
        return p;
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

    public LNode(int data) {
        this.data = data;
        this.next = null;
    }
}
