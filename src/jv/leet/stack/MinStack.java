package jv.leet.stack;

import java.util.Stack;

/**
 * 最小栈
 * <p></p>
 * 两种方法，
 * <p></p>
 * 方法1： 使用两个栈来记， 一个栈记录入栈的数字，另一个栈记录当前最小值
 * <p></p>
 * 方法2： 使用一个栈 + 当前最小值记录， 栈中记录当前最小值与前一个数的差值。
 */
public class MinStack {

    public static void main(String[] args) {


    }

    public static class MinStack1 {

        private static Stack<Integer> stack = new Stack<>();
        private static int minValue;

        public static void push(int num) {

            int diff = num - minValue;
            stack.push(diff);
            minValue = diff > 0 ? minValue : num;
        }

        public static int pop() {


            if (stack.isEmpty()) {
                return Integer.MIN_VALUE;
            }

            Integer diff = stack.pop();

            int top;
            if (diff < 0) {
                top = minValue;
                minValue = top - diff;
            } else {
                top = minValue + diff;
            }

            return top;
        }

        public static int top() {

            if (stack.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int diff = stack.get(stack.size() - 1);

            return diff < 0 ? minValue : minValue + diff;

        }

        public static int getMin() {
            return stack.isEmpty() ? Integer.MIN_VALUE : minValue;
        }

    }
}
