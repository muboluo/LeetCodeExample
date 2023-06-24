package jv.leet.list;


// 合并两个有序list
public class Merge2SortedList {

    public static void main(String[] args) {

    }

    private static ListNode mergeTwoSortedLists(ListNode node1, ListNode node2) {


        ListNode current = new ListNode();
        current.setValue("-1");
        ListNode head = current;

        while (node1 != null && node2 != null) {

            if (Integer.parseInt(node1.getValue()) <= Integer.parseInt(node2.getValue())) {

                current.setNext(node1);
                node1 = node1.getNext();
            } else {
                current.setNext(node2);
                node2 = node2.getNext();
            }
            current = current.getNext();
        }

        // 设置 下一个点
        current.setNext(node1 == null ? node2 : node1);
        return head.getNext();
    }

}
