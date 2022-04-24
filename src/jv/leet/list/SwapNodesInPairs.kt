package jv.leet.list


/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * <p>
 * 解题关键：
 * <p>
 * 1 递归
 * <p>
 *
 * <p>
 * 2 迭代
 * <p>
 * 两两一组，创建一个 dummyHead ,指向每组的第1个node， 交换 两个node，并将 dummyHead.next 指向 node2的next
 */
class SwapNodesInPairs {

    companion object {

        fun swapNode(head: ListNode?): ListNode? {

            ListNode.printNode(head)

            var dummyHead = ListNode(head)
            var temp = dummyHead
            // 设置 terminal
            while (temp.next != null && temp.next?.next != null) {

                // 获取 node1 node2
                var node1 = temp.next
                var node2 = temp.next?.next
                // handle current level
                // temp -> node1 -> node2
                // 更新上一个层级指向新的 "node1"
                temp.next = node2  // temp ->  node2
                // exchange node
                node1?.next = node2?.next // node1 -> node3
                node2?.next = node1 // node2 -> node1
                // jump next level, reset clause
                if (node1 != null) {
                    temp = node1
                }
            }
            ListNode.printNode(dummyHead.next)
            return dummyHead.next

        }

        fun swapNode2(nodeHead: ListNode?): ListNode? {

            ListNode.printNode(nodeHead)

            if (nodeHead == null) {
                return null
            }

            val dummyHead = ListNode(nodeHead)
            var temp = dummyHead

            while (temp.next != null && temp.next?.next != null) {

                var node1 = temp.next
                var node2 = temp.next?.next

                // update pre level point @
                temp.next = node2

                // handle current level
                node1?.next = node2?.next
                node2?.next = node1

                // jump next level and reset clause
                if (node1 != null) {
                    temp = node1
                }

            }

            ListNode.printNode(dummyHead.next)
            return dummyHead.next
        }

        // 递归， 实现 ListNode 两两交换
        fun swapNodeRecursive(nodeHead: ListNode?): ListNode? {

            // set terminal
            if (nodeHead?.next == null) {
                return nodeHead
            }
            // handle current level
            var newHead = nodeHead.next
            nodeHead.next = swapNodeRecursive(newHead?.next)
            newHead?.next = nodeHead
            // jump next level
            // reset clause
            return newHead
        }

        fun swapNodeRecursive2(nodeHead: ListNode?): ListNode? {
            // set terminal
            if (nodeHead?.next == null) {
                return nodeHead
            }
            // handle current level
            var newHead = nodeHead.next
            nodeHead.next = swapNodeRecursive(newHead?.next)
            newHead?.next = nodeHead

            // jump next level
            // reset clause
            return newHead

        }

        fun swapNode3(nodeHead: ListNode?): ListNode? {
            // 两两分株，改变 next 指向
            // 前一组的 next  -> node2, node2 -> node1, node1 -> 下一组
            ListNode.printNode(nodeHead)

            if (nodeHead == null) {
                return null
            }

            var dummyHead = ListNode(nodeHead)
            var temp = dummyHead

            while (temp.next != null && temp.next?.next != null) {
                var node1 = temp.next
                var node2 = temp.next?.next

                temp.next = node2
                node1?.next = node2?.next
                node2?.next = node1

                if (node1 != null) {
                    temp = node1
                }
            }

            ListNode.printNode(dummyHead.next)
            return dummyHead.next
        }

        fun swapNodeRecursive3(nodeHead: ListNode?): ListNode? {

            // terminal, 传入的是当前层的第一个元素
            if (nodeHead?.next == null) {
                return nodeHead
            }
            // handle current level
            // newHead -> 2 4 6 8
            val newHead = nodeHead?.next
            // nodeHead -> 1 3 5 7, 交换后，指向下一层
            nodeHead.next = swapNodeRecursive3(newHead?.next)
            // 交换后，指向 1 3 5 7
            newHead?.next = nodeHead
            return newHead
        }
    }

}

fun main() {

    var node1 = ListNode()
    var node2 = ListNode(node1)
    var node3 = ListNode(node2)
    var nodeHead = ListNode(node3)
//    SwapNodesInPairs.swapNode(nodeHead)
//    SwapNodesInPairs.swapNode2(nodeHead)
//    SwapNodesInPairs.swapNode3(nodeHead)
    ListNode.printNode(nodeHead)
//    val result = SwapNodesInPairs.swapNodeRecursive(nodeHead)
//    val result = SwapNodesInPairs.swapNodeRecursive2(nodeHead)
    val result = SwapNodesInPairs.swapNodeRecursive3(nodeHead)
    ListNode.printNode(result)

}