package jv.leet.list

fun cycleII(head: ListNode?): ListNode? {

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

        if (fast == slow) {

            var third = head
            while (third != head) {
                third = third?.next
                slow = slow?.next
            }
            return third
        }
    }
    return null
}

fun main() {

}