package jv.leet.list;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动k 个位置，其中k 是非负数
 * 输入: 1->2->3->4->5->NULL, k = 2输出: 4->5->1->2->3->NULL解释:
 * 向右旋转 1步: 5->1->2->3->4->NULL向石旋转2步: 4>5->1->2->3->NULL
 */
public class RotateKList {

    public static void main(String[] args) {

    }

    // 第二遍
    private static ListNode rotate2(ListNode head, int k) {

        if (head == null || k <= 0) {
            return head;
        }

        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = preHead;
        ListNode fast = preHead;
        ListNode slow = preHead;

        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        if (k % count == 0) {
            return head;
        }

        k = k % count;

        while (k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = preHead.next;
        preHead.next = slow.next;
        slow.next = null;

        return preHead.next;
    }

    private static ListNode rotate(ListNode head, int k) {

        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        // set current temp
        ListNode headPre = new ListNode(-1);
        headPre.next = head;
        ListNode cur = headPre;
        ListNode fast = head;
        ListNode slow = head;

        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        // 如果 count 为 0，或者移动次数为 count 的整数倍，则不需要移动。
        if (count == 0 || k % count == 0) {
            return head;
        }

        // 重新计算 k
        k = k % count;

        // 移动fast 到 k 位置处，k 表示 fast 和 slow 之间的间隔。
        while (k > 0 && fast.next != null) {
            fast = fast.next;
            k--;
        }

        // 开始移动 slow ,保持和 fast 的 k 个间隔
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 移动完之后，重新拼接 list
        fast.next = headPre.next;
        headPre.next = slow.next;
        slow.next = null;

        return headPre.next;
    }


    private static class ListNode {

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode next;
        public int value;

    }

}
