package jv.leet.list;

//删除倒数第 N 个节点
public class DeleteCountdownNNode {

    public static void main(String[] args) {

    }

    private static ListNode removeEnd2(ListNode head, int num) {

        if (head == null || num < 0) {
            return head;
        }

        int count = 0;
        ListNode cur = head;

        while (cur != null) {
            cur = cur.next;
            count++;
        }

        if (count < num) {
            return head;
        }

        int del = count - num;

        cur = head;

        while (del > 0) {
            cur = cur.next;
            del--;
        }

        cur.next = cur.next.next;

        return head;
    }

    private static ListNode removeEnd(ListNode head, int num) {


        if (head == null || num < 0) {
            return head;
        }

        int count = 0;
        // 提供这个哑节点，是为了
        // 1. 适配边界条件 正数位置为 0 的case.
        // 2. 在最后查找删除项过程中，定位到被删除项的前一项。
        ListNode tempHead = new ListNode();
        tempHead.next = head;

        ListNode cur = tempHead;

        while (cur.next != null) {
            count++;
            cur = cur.next;
        }

        if (count < num) {
            return head;
        }

        int del = count - num;

        cur = tempHead;


        while (del > 0) {
            cur = cur.next;
            del--;
        }

        cur.next = cur.next.next;
        return tempHead.next;
    }

    private static ListNode removeBackwardK(ListNode head, int backwardK) {

        if (head == null) {
            return null;
        }

        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode current = preHead;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }

        if (count < backwardK) {
            return preHead.next;
        }

        int forwardK = count - backwardK;

        current = preHead;
        while (forwardK > 0) {

            current = current.next;
            forwardK--;
        }

        current.next = current.next.next;

        return preHead.next;
    }


    private static class ListNode {

        public ListNode next;
        public int value;

    }

}
