package jv.leet.list;

public class DeleteRepeatNode {

    public static void main(String[] args) {

    }

    private ListNode delete2(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode temp = head;

        while (temp.next != null) {

            if (temp.next.value == temp.value) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    private ListNode delete(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode temp = head;

        while (temp.next != null) {

            if (temp.value == temp.next.value) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }


    private static class ListNode {

        public ListNode next;
        public int value;

    }

}
