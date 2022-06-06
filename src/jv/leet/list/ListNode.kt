package jv.leet.list

class ListNode(var next: ListNode? = null, var value: String = "") {

    companion object {

        fun printNode(node: ListNode?) {
            var print = node
            while (print != null) {
                System.out.print(print.value)
                System.out.print(" ")
                print = print.next
            }
            System.out.println("-----------")
        }

        fun createListNodeList(valueList: Array<String>): ListNode? {

            var hair: ListNode? = ListNode(null, "-1")

            var preHead: ListNode? = hair


            for (value in valueList) {
                preHead?.next = ListNode(null, value)
                preHead = preHead?.next

            }

            return hair?.next

        }
    }
}
