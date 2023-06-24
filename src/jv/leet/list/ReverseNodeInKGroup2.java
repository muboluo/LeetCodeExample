package jv.leet.list;

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
            result2 = result2 + " " +  temp.value;
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
        // 每组数据遍历时，该组数据之前的一项。
        ListNode preHeadByGroup = preHead;
        int n = k;

        while (preHeadByGroup.next != null) {

            // 因为在后面需要处理队尾和队首，所以需要一个临时变量，记录队尾。
            ListNode tempNode = preHeadByGroup;

            while (n > 0 && tempNode.next != null) {
                tempNode = tempNode.next;
                n--;
            }

            // 如果遍历完成
            if (n == 0) {
                ListNode nextWhileNode = tempNode.next;
                // 在翻转钱的头部数据 = 翻转后的尾部数据。
                ListNode tailInGroupAfterReverse = preHeadByGroup.next;
                // 先断开旧数据
                tempNode.next = null;
                preHeadByGroup.next = reverseNode(tailInGroupAfterReverse);
                tailInGroupAfterReverse.next = nextWhileNode;
                n = k;
                preHeadByGroup = tailInGroupAfterReverse;

            } else {
                // 已经到达队尾
                break;
            }

        }

        return preHead.next;

    }

    /**
     * 反转
     */
    private static  ListNode reverseNode(ListNode head){
        ListNode cur = head;
        ListNode pre = head;
        while (cur !=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre =cur;
            cur = temp;
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
