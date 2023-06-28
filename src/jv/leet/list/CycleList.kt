package jv.leet.list

/**
 * 环形链表
 * 给你一个链表的头结点head,判断链表中是否有环。
 * <p>
 * https://leetcode-cn.com/problems/linked-list-cycle/solution/yi-wen-gao-ding-chang-jian-de-lian-biao-wen-ti-h-2/
 * <p>
 * 连接中，这个一文搞定的思路很牛x。
 * 这是一个相遇问题, 如果存在环，则快慢指针一定会相遇
 */
fun cycle(node: ListNode?): Boolean {

    var fast = node
    var slow = node

    while (fast != null) {
        fast = fast.next
        if (fast == null) {
            return false
        }
        fast = fast.next

        if (fast == slow) {
            return true
        }
        slow = slow?.next
    }

    return false
}

fun cycle2(node: ListNode?): Boolean {

    if (node == null) {
        return false
    }

    var fast = node
    var slow = node

    while (fast != null) {
        fast = fast.next
        if (fast == null) {
            return false
        }
        fast = fast.next
        if (fast == null) {
            return false
        }
        if (fast == slow) {
            return true
        }

        slow = slow?.next
    }

    return false
}

fun cycle3(head: ListNode?): Boolean {
    if (head == null) {
        return false
    }
    var fast = head
    var slow = head
    while (fast != null) {

        fast = fast.next
        if (fast == null) {
            return false
        }

        fast = fast.next
        if (fast == slow) {
            return true
        }

        slow = slow?.next
    }
    return false
}

fun cycle4(head: ListNode?): Boolean {

    if (head == null) {
        return false;
    }

    var slow = head
    var fast = head.next

    while (fast?.next != null) {

        if (fast == slow) {
            return true
        }

        fast = fast.next?.next
        slow = slow?.next
    }

    return false;
}

fun cycle5(head: ListNode?): Boolean {

    if (head == null) {
        return false
    }

    var slow: ListNode? = head

    var fast: ListNode? = head.next

    while (fast?.next != null) {

        if (fast == slow) {
            return true
        }

        fast = fast.next?.next
        slow = slow?.next
    }
    return false
}

fun main() {

    val node1 = ListNode()
    val node2 = ListNode(node1)
    val node3 = ListNode(node2)
    val node4 = ListNode(node3)
    val node5 = ListNode(node4)
    val node6 = ListNode(node5)
    val node7 = ListNode(node6)
    node1.next = node4
    System.out.println(cycle(node7))
}