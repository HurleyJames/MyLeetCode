package medium._002

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val head = ListNode(0)
    var p = l1
    var q = l2
    var curr: ListNode? = head
    // 进位carry初始化为0
    var carry = 0
    while (p != null || q != null) {
        // 如果p不为空，将x设为结点p的值；如果p已到达l1的末尾，则p=null，则x=0
        val x = p?.`val` ?: 0
        // q同理
        val y = q?.`val` ?: 0
        val sum = x + y + carry
        // 将carry取整
        carry = sum / 10
        curr!!.next = ListNode(sum % 10)
        curr = curr.next
        if (p != null) {
            p = p.next
        }
        if (q != null) {
            q = q.next
        }
    }
    // 检查carry是否等于1
    if (carry > 0) {
        curr!!.next = ListNode(carry)
    }
    return head.next
}

/**
 * 打印链表
 * @param last
 */
fun printList(last: ListNode?) {
    var last = last
    while (last != null) {
        // 如果是最后一位，则不输出逗号，
        if (last.next == null) {
            print(last.`val`)
        } else {
            // 如果不是最后，则输入逗号，分隔
            print(last.`val`.toString() + ",")
        }
        last = last.next
    }
}

fun main() {
    // 原测试用例：l1=[2,4,3]，l2=[5,6,4]，输出结果为[7,0,8]
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(3)
    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next!!.next = ListNode(4)
// 测试用例1：l1=[0,1]，l2=[0,1,2]，输出结果应为[0,2,2]
//        ListNode l1 = new ListNode(0);
//        l1.next = new ListNode(1);
//        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(1);
//        l2.next.next = new ListNode(2);
// 测试用例2：l1=[]，l2=[0,1]，输出结果为[0,1]
//        ListNode l1 = new ListNode();
//        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(1);
// 测试用例l3：l1=[9,9]，l2=[1]，输出结果为[0,0,1]
//        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(9);
//        ListNode l2 = new ListNode(1);
    printList(addTwoNumbers(l1, l2))
}


/**
 * ListNode是自己定义的Java中的链表对象
 * 类结构如下
 */
class ListNode {
    var `val`: Int
    var next: ListNode? = null

    constructor() {
        `val` = 0
    }

    constructor(i: Int) {
        `val` = i
    }

    fun `val`(): Int {
        return `val`
    }
}
