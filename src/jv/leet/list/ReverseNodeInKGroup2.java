package jv.leet.list;

/**
 * 定义头部 preHead 和每组的头部数据 groupPreHead
 * k 个一组遍历数据
 * 翻转前，确定 上组数据的尾部和下组数据的头部
 * 翻转过程中，定义 pre 和 cur 两个临时变量辅助
 * 翻转后拼接起来
 * 返回 preHead.
 */
public class ReverseNodeInKGroup2 {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        ListNode a7 = new ListNode(7);
        ListNode a8 = new ListNode(8);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = a8;
        a8.next = null;

        ListNode temp1 = a1;
        String result = "";
        while (temp1 != null) {
            result = result + temp1.value;
            temp1 = temp1.next;
        }
        System.out.println(result);

        ListNode head = reverseNodeGroup(a1, 3);

        ListNode temp = head;
        String result2 = "";
        while (temp != null) {
            result2 = result2 + " " + temp.value;
            temp = temp.next;
        }
        System.out.println(result2);
    }

    private static ListNode reverseNodeGroup(ListNode node, int k) {

        if (node == null || k <= 0) {
            return node;
        }

        ListNode preHead = new ListNode(-1);
        preHead.next = node;
        //遍历 当前组数据的前一项
        ListNode preHeadByGroup = preHead;

        int n = k;

        while (preHeadByGroup.next != null) {

            ListNode temp = preHeadByGroup;

            while (n > 0 && temp.next != null) {
                temp = temp.next;
                n--;
            }

            if (n == 0) {

                ListNode headInNextGroup = temp.next;
                ListNode tailAfterReverseInGroup = preHeadByGroup.next;

                temp.next = null;

                preHeadByGroup.next = reverseNode(tailAfterReverseInGroup);
                tailAfterReverseInGroup.next = headInNextGroup;
                preHeadByGroup = tailAfterReverseInGroup;
                n = k;

            } else {
                break;
            }
        }

        return preHead.next;

    }

    /**
     * 反转
     */
    private static ListNode reverseNode(ListNode head) {
        ListNode cur = head;
        ListNode pre = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    private static ListNode reverse(ListNode node, int k) {
        // 1. set terminal
        if (node == null || k <= 0) {
            return node;
        }

        // 2. init temp
        ListNode preHead = new ListNode(-1);
        preHead.next = node;
        // 每组的前一项
        ListNode preKGroup = preHead;

        int i = k;

        // 3. set loop clause
        while (preKGroup.next != null) {

            ListNode current = preKGroup;

            while (i > 0 && current.next != null) {
                current = current.next;
                i--;
            }

            // 4. set loop terminal
            if (i > 0) {
                return preHead.next;
            }

            // 5. record preHead ande end
            ListNode headBeforeReverse = preKGroup.next;
            ListNode headInNext = current.next;

            current.next = null;

            // reverseNode
            preKGroup.next = reverseNodeGroup2(headBeforeReverse);

            // 反转后的队尾
            headBeforeReverse.next = headInNext;

            i = k;
            preKGroup = headBeforeReverse;

        }

        return preHead.next;

    }

    private static ListNode reverseNodeGroup2(ListNode node) {
        ListNode pre = node;
        ListNode current = node;

        // 这里注意最后边界条件的判断。
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    private static class ListNode {

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode next;
        public int value;

    }
}
