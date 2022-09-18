package jv.leet.stack;

// 最小栈，使用 list 实现
//* 最小栈: https://leetcode.cn/problems/min-stack/
public class MinStack2 {

    private Node head;

    public void push(int val) {

        if (head == null) {
            head = new Node(val, val);
        } else {
            head = new Node(val, val, head);
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int getMin() {
        return head != null ? head.min : 0;
    }

    public int top() {
        return head != null ? head.x : 0;
    }


    public static class Node {

        int x;
        int min;
        Node next;

        public Node(int x, int min, Node next) {
            this.x = x;
            this.min = min;
            this.next = next;
        }

        public Node(int x, int min) {
            this(x, min, null);
        }
    }
}
