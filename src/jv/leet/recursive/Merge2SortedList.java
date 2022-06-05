package jv.leet.recursive;

import jv.leet.list.ListNode;

/**
 * 合并两个有序链表
 * <p></p>
 * https://leetcode.cn/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
 * <p></p>
 * 解题思路：
 * <p></p>
 * 解法1：递归。比较并且返回， 二者中，更小的那个。如果是null， 则说明该list 到最后一个节点了。返回另一个节点即可。
 * <p></p>
 * 解法2：
 */
public class Merge2SortedList {

    private static ListNode merge11(ListNode head1, ListNode head2) {


        if (head1 == null || "".equals(head1.getValue())) {
            return head2;
        } else if (head2 == null || "".equals(head2.getValue())) {
            return head1;
        } else if (Integer.parseInt(head1.getValue()) < Integer.parseInt(head2.getValue())) {
            head1.setNext(merge11(head1.getNext(), head2));
            return head1;
        } else {
            head2.setNext(merge11(head1, head2.getNext()));
            return head2;
        }


    }

    // 递归， return 的是 下一个添加到list 中的较小节点。
    private static ListNode merge12(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else if (Integer.parseInt(head1.getValue()) < Integer.parseInt(head2.getValue())) {
            head1.setNext(merge12(head1.getNext(), head2));
            return head1;
        } else {
            head2.setNext(merge12(head1, head2.getNext()));
            return head2;
        }

    }

    private static void merge21(ListNode head1, ListNode head2) {

    }

    private static void merge22(ListNode head1, ListNode head2) {

    }


    public static void main(String[] args) {

        ListNode node15 = new ListNode(null, "8");
        ListNode node14 = new ListNode(node15, "6");
        ListNode node13 = new ListNode(node14, "4");
        ListNode node12 = new ListNode(node13, "3");
        ListNode node11 = new ListNode(node12, "1");

        ListNode node24 = new ListNode(null, "10");
        ListNode node23 = new ListNode(node24, "7");
        ListNode node22 = new ListNode(node23, "5");
        ListNode node21 = new ListNode(node22, "2");


//        ListNode result = merge11(node11, node21);
//        ListNode.Companion.printNode(result);

        ListNode result2 = merge12(node11, node21);
        ListNode.Companion.printNode(result2);


    }
}
