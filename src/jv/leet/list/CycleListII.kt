package jv.leet.list

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 * </p>
 * 1 哈希表法
 * </p>
 * 遍历 list， 同时记录，如果遍历过程中发现有重复的，说明存在环
 * </p>
 * 时间复杂度 O(N) ，空间复杂度O(N)
 * </p>
 * 2 快慢指针
 * </p>
 * 使用 a b c 公式，推导出一个 当 快慢指针相遇时，再从 head 出发一个 指针，最终会在 环的起点，与 slow 相遇。
 * 具体推导步骤，参看 链接中的 官方解法
 * </p>
 * 时间复杂度 O(N)  空间复杂度 O(1)
 */
fun cycleIIFastSlow1(head: ListNode?): ListNode? {

    if (head == null) {
        return null
    }
    var fast = head
    var slow = head

    while (fast != null) {

        slow = slow?.next

        if (fast.next == null) {
            return null
        }

        fast = fast.next?.next
        if (fast != slow) {
            continue
        }

        var third = head
        while (third != slow) {
            third = third?.next
            slow = slow?.next
        }
        return third
    }
    return null
}

fun cycleIIHashSet1(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    var set: MutableSet<ListNode> = mutableSetOf()
    var current = head

    while (current != null) {

        if (set.contains(current)) {
            return current
        } else {
            set.add(current)
        }
        current = current.next
    }
    return null
}

fun main() {

}