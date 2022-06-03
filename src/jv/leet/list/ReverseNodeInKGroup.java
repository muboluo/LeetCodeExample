package jv.leet.list;

/**
 * k 个一组，翻转list
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/solution/k-ge-yi-zu-fan-zhuan-lian-biao-by-leetcode-solutio/
 * <p/>
 * 3个步骤
 * 1. 找到每组的队首队尾，和 队首.pre , 队尾.next
 * 2. 将该组拆出来，进行翻转
 * 3. 将翻转后的 队列接回去
 * 注意，其中涉及到一些状态保存。
 */
public class ReverseNodeInKGroup {

    public static ListNode reverse(ListNode head, int k) {

        // set terminal clause
        // 不需要判断 输入head， 在while 循环中判断了

        // init clause
        ListNode hair = new ListNode();
        hair.setNext(head);

        // set first group preHead
        ListNode preHead = hair;

        while (head != null) {

            // 当前 group 的 head
            ListNode headInGroup = head;
            ListNode preHeadInGroup = preHead;
            // set terminal , and get tail
            for (int i = 0; i < k; i++) {
                preHeadInGroup = preHeadInGroup.getNext();
                if (preHeadInGroup == null) {
                    return hair.getNext();
                }
            }
            // head 已经移动只队尾， 两两交换的 尾节点
            ListNode tail = preHeadInGroup;

            // 两两交换的第一个节点， 用于while 循环
            ListNode first = headInGroup;

            // 记录下一组的开始位置，用于循环结束后，传值
            ListNode tailNext = tail.getNext();

            // 创建翻转过程中，上一次翻转过程中的 first 变量 preFirst
            // 翻转后， preFirst 变为了 当次翻转的 next
            // 因为，首先，我们是从 head 开始翻转。
            // 完成翻转后，翻转前的 head 移动到了队尾，指向 下一组的 head
            // 所以，preFirst 初始值为  tail.getNext();
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
            tail = headInGroup;
            // preFirst 指向的是，翻转前的队首 ，即翻转后，队首。
            headInGroup = preFirst;

            // 把list 接回 列表中
            tail.setNext(tailNext);
            preHead.setNext(headInGroup);
            preHead = tail;
            head = tail.getNext();

        }

        return hair.getNext();

    }

    public ListNode reverse2(ListNode head, int k) {

        ListNode hair = new ListNode();
        hair.setNext(head);

        ListNode preHead = hair;

        while (head != null) {

            ListNode headInGroup = head;
            for (int i = 0; i < k; i++) {

                head = head.getNext();
                if (head == null) {
                    return hair.getNext();
                }
            }
            ListNode tailInGroup = head;
            ListNode tailNext = tailInGroup.getNext();

            ListNode preFirst = tailInGroup.getNext();
            ListNode first = headInGroup;

            while (preFirst != tailInGroup) {

                ListNode second = first.getNext();
                first.setNext(preFirst);

                preFirst = first;
                first = second;
            }

            ListNode newTailInGroup = headInGroup;
            ListNode newHeadInGroup = tailInGroup;

            preHead.setNext(newHeadInGroup);
            newTailInGroup.setNext(tailNext);
            // jump next level
            preHead = newTailInGroup;
            head = tailNext;
        }

        return hair.getNext();

    }

    // 分3步： 1 找到当前第 n 组 ，以及 前一个，后一个，  2 翻转 第 n 组， 3 将 第 n 组 接回去
    public ListNode reverse3(ListNode head, int k) {

        ListNode hair = new ListNode();
        hair.setNext(head);

        ListNode preHead = hair;
        while (head != null) {

            ListNode headInGroup = head;
            for (int i = 0; i < k; i++) {
                head = head.getNext();
                if (head == null) {
                    return hair.getNext();
                }
            }

            ListNode tailInGroup = head;
            ListNode tailNext = tailInGroup.getNext();

            // 取 翻转后 当前 node next 的 初始值, 第一个位置，指向的 next 是 下一个group 的开始位置
            ListNode preFirst = tailInGroup.getNext();
            ListNode first = headInGroup;

            while (preFirst != tailInGroup) {

                ListNode second = first.getNext();
                first.setNext(preFirst);
                preFirst = first;
                first = second;
            }

            ListNode newHeadInGroup = tailInGroup;
            ListNode newTailInGroup = headInGroup;

            preHead.setNext(newHeadInGroup);
            newTailInGroup.setNext(tailNext);

            // jump next level
            preHead = newTailInGroup;
            head = tailNext;
        }
        return hair.getNext();
    }


    public static void main(String[] args) {


    }
}

