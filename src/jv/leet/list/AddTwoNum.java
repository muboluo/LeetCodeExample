package jv.leet.list;

// 两数相加

/**
 * 给出两个非空的链表用来表示两个非负的整数其中，它们各自的位数是按照 逆序的方式存储的，并且它们的每个节点只能存储 一位 数字我们将这两个数相加起来，则会返回一个新的链表来表示它们的和您可以假设除了数字 0之外，这两个数都不会以0开头。
 * 输入 :(2->4-> 3) +(5 -> 6-> 4)输出:7->0-> 8原因 :342 + 465 = 807
 */
public class AddTwoNum {
    public static void main(String[] args) {

    }

    private static ListNode add2(ListNode head1, ListNode head2) {

        ListNode result = new ListNode(-1);
        ListNode currentNode = result;

        if (head1 == null && head2 == null) {
            return result;
        }

        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int carry = 0;

        while (cur1 != null || cur2 != null) {

            int currentTotal = cur1 == null ? 0 : cur1.value + (cur2 == null ? 0 : cur2.value) + carry;

            carry = currentTotal > 10 ? 1 : 0;
            currentTotal = currentTotal % 10;

            // 解法 1 与这里的解法不太相同，但基本一致。去别在于是否使用新的空间。
            currentNode.next = new ListNode(currentTotal);

            cur1 = cur1 != null ? cur1.next : null;
            cur2 = cur2 != null ? cur2.next : null;
            currentNode = currentNode.next;
        }

        if (carry == 1) {
            currentNode.next = new ListNode(1);
        }

        return result;
    }

    private static ListNode add(ListNode head1, ListNode head2) {

        ListNode result = null;
        ListNode resultHead = null;

        ListNode node1 = head1;
        ListNode node2 = head2;

        // 定义下层携带的数据
        int carry = 0;
        while (node1 != null || node2 != null) {

            // 计算本层数据
            int currentTotal = (node1 == null ? 0 : node1.value) + (node2 == null ? 0 : node2.value) + carry;

            carry = currentTotal > 10 ? 1 : 0;

            currentTotal %= 10;

            // save currentTotal
            result = node1 == null ? node2 : node1;
            if (resultHead == null) {
                resultHead = result;
            }
            result.value = currentTotal;

            // set next level status
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
            result.next = node1 != null ? node1 : node2;
            // jump next level
        }

        if (carry >= 1) {
            result.next = new ListNode(1);
        }

        return resultHead;
    }


    private static class ListNode {

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode next;
        public int value;

    }

}
