package jv.leet.list;


// 合并两个有序list
public class Merge2SortedList {

    public static void main(String[] args) {

    }

    private static ListNode mergeTwoSortedLists(ListNode node1, ListNode node2) {


        ListNode current = new ListNode();
        current.value = -1;
        ListNode head = current;

        while (node1 != null && node2 != null) {

            if (node1.value <= node2.value) {

                current.next = node1;
                node1 = node1.next;
            } else {

                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }

        // 设置 下一个点
        current.next = (node1 == null ? node2 : node1);
        return head.next;
    }

    private static ListNode mergeTwoSortedList2(ListNode node1, ListNode node2) {

        if (node1 == null && node2 == null) {
            return null;
        }

        ListNode preHead = new ListNode();
        preHead.value = -1;
        ListNode cur = preHead;

        while (node1 != null && node2 != null) {

            if (node1.value <= node2.value) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }

        cur.next = node1 != null ? node1 : node2;

        return preHead.next;
    }


    private static class ListNode {

        public ListNode next;
        public int value;

    }

}
