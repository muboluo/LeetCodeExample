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
    }
}
