package jv.leet.list;

public class ReverseNodeInKGroup {

    public static ListNode reverse(ListNode head, int k) {

        // set terminal clause
        if (head == null) {
            return null;
        }

        // init clause
        ListNode hair = new ListNode();
        hair.setNext(head);

        ListNode preHead = hair;

        while (head != null) {

            // 当前 group 的 head
            ListNode headInGroup = head;
            // set ternimal , and get tail
            for (int i = 0; i < k; i++) {
                head = head.getNext();
                if (head == null) {
                    return hair.getNext();
                }
            }
            // head 已经移动只队尾， 两两交换的 尾节点
            ListNode tail = head;

            // 两两交换的第一个节点， 用于while 循环
            ListNode first = headInGroup;

            // 记录下一组的开始位置，用于循环结束后，传值
            ListNode tailNext = tail.getNext();

            // 翻转后，first 指向 preFirst，用于 内部 while 循环
            ListNode preFirst = tail.getNext();


            while (preFirst != tail) {

                // handle current level
                ListNode second = first.getNext();
                first.setNext(preFirst);

                // reset clause
                preFirst = first;
                first = second;

                // while , jump next level
            }

            // while 之后，headInGroup 指向的是 翻转后 队尾，
            // preFirst 指向的是，翻转后，队首。
            tail = headInGroup;
            headInGroup = preFirst;

            tail.setNext(tailNext);
            preHead.setNext(headInGroup);
            preHead = tail;
            head = tail.getNext();

        }

        return hair.getNext();

    }


    public static void main(String[] args) {


    }
}

