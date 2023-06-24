package jv.leet.list

/**
 * 翻转链表
 * <p>
 * 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。
 * <p>
 * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
 * <p>
 * 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
 * <p>
 * 方法1 的时间复杂度 O(n) 空间复杂度 O(1)
 * 方法2 的时间复杂度 O(n) 空间复杂度 O(n)
 */
class ReverseList {

    companion object {

        fun reverseList(head: ListNode): ListNode? {

            var pre: ListNode? = null
            var cur: ListNode? = head

            while (cur != null) {
                val next = cur.next
                cur.next = pre
                pre = cur
                // jump next level
                cur = next
            }
            return pre
        }

        fun reverseList2(head: ListNode): ListNode? {

            var pre: ListNode? = null
            var cur: ListNode? = head
            while (cur != null) {
                val next = cur.next
                cur.next = pre
                pre = cur
                cur = next
            }
            return pre
        }

        fun reverseList4(head: ListNode?): ListNode? {
            var pre: ListNode? = null
            var cur = head

            while (cur != null) {
                var next = cur.next
                cur.next = pre
                pre = cur
                cur = next
            }

            return pre
        }

        fun reverseList3(head: ListNode): ListNode? {
            var pre: ListNode? = null
            var cur: ListNode? = head
            while (cur != null) {
                var next = cur.next
                cur.next = pre
                pre = cur
                cur = next
            }
            return pre
        }

        fun reverseList5(head: ListNode?): ListNode? {

            var pre : ListNode? = null
            var current : ListNode? = head

            while (current != null) {

                val temp : ListNode? = current.next

                current.next = pre
                pre = current
                current = temp
            }


            return pre
        }

        fun reverseListMethod2(head: ListNode): ListNode? {
            var result: ListNode? = null
            var cur: ListNode? = head
            while (cur != null) {
                // 参数一 表示 next ，参数2 表示当前value
                result = ListNode(result, cur.value)
                cur = cur.next
            }

            return result
        }

        fun reverseListMethod22(head: ListNode): ListNode? {

            var next: ListNode? = null
            var cur: ListNode? = head
            while (cur != null) {
                // 取出当前节点的value，复制给next 节点。
                next = ListNode(next, cur.value)
                cur = cur.next
            }
            return next
        }

        fun reverseListMethod23(head: ListNode): ListNode? {

            var next: ListNode? = null
            var current: ListNode? = head

            while (current != null) {
                // 取出当前的 value 和 需要指向的next， 存储至 next 中
                next = ListNode(next, current.value)
                current = current.next
            }

            return next
        }

        fun reverseListMethod24(head: ListNode): ListNode? {
            // set first next
            var next: ListNode? = null
            var current: ListNode? = head

            while (current != null) {
                next = ListNode(next, current.value)
                current = current.next
            }
            return next
        }
    }


}

fun main() {
    var node4: ListNode = ListNode()
    var node3: ListNode = ListNode(node4)
    var node2: ListNode = ListNode(node3)
    var node1: ListNode = ListNode(node2)
    val node5 = ReverseList.reverseList2(node1)

    System.out.println(node5)

}