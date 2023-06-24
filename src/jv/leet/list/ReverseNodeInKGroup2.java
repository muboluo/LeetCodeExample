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
        if (node == null || k <= 0){
            return node;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode p = dummy;
        int n = k;
        while (p.next != null){
            ListNode temp = p;
            while (temp.next != null && n > 0){
                temp = temp.next;
                --n;
            }
            if (n == 0){
                ListNode nextNode = temp.next;
                ListNode tailNode = p.next;
                //先断开
                temp.next = null;
                p.next=reverseNode(tailNode);
                tailNode.next = nextNode;
                n = k;
                p = tailNode;
            }else{
                //此时数量不足K个
                break;
            }
        }
        return dummy.next;
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
