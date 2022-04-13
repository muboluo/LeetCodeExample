package jv.leet.list

import javax.swing.ListModel

/**
 * 反转链表
 * <p>
 * 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。
 * <p>
 * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
 * <p>
 * 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
 * <p>
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 */
class ReverseList {

    companion object {

        fun reverseList(head: ListNode): ListNode? {

            var pre: ListNode? = null
            var cur: ListNode? = head

            while (cur != null) {

                val next: ListNode? = cur.next
                cur.next = pre
                pre = cur
                cur = next
            }
            return pre
        }
    }


    class ListNode(var next: ListNode? = null) {
    }

}

fun main() {
    var node4: ReverseList.ListNode = ReverseList.ListNode()
    var node3: ReverseList.ListNode = ReverseList.ListNode(node4)
    var node2: ReverseList.ListNode = ReverseList.ListNode(node3)
    var node1: ReverseList.ListNode = ReverseList.ListNode(node2)
    val node5 = ReverseList.reverseList(node1)

    System.out.println(node5)

}