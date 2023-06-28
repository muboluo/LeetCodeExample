package jv.leet.list;

/**
 * 找到两个单链表相交的起始节点
 * A链表:4->1->8->4->5
 * B链表:5->0->1->8->4->5
 * 相交点:8
 */
public class IntersectionList {

    public static void main(String[] args) {

    }

    private static ListNode intersect(ListNode head1, ListNode head2) {

        if (head1 == null && head2 == null) {
            return null;
        }

        ListNode l1 = head1;
        ListNode l2 = head2;

        // 这里不是判断 值，而是判断引用是否是同一个。
        while (l1 != l2) {
            // 这里不要搞错顺序了。交换 head1 和 head2，
            // 可以让 size 不相同的 list 第二次开始遍历的时候，
            // 从距离相交点相同位置的节点开始遍历。
            l1 = l1.next == null ? head2 : l1.next;

            l2 = l2.next == null ? head1 : l2.next;
        }
        return l1.next;
    }

    private static ListNode intersect2(ListNode head1, ListNode head2) {

        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode cur1 = head1;
        ListNode cur2 = head2;

        while (cur1 != cur2) {
            cur1 = cur1.next != null ? cur1.next : head2;
            cur2 = cur2.next != null ? cur2.next : head1;
        }
        return cur1;
    }

    private static class ListNode {

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode next;
        public int value;

    }
}
