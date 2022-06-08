package jv.leet.list

import java.util.*

/**
 * 是否是有效括号
 *
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * 解法1： 入栈，出栈
 *
 */
class ValidBrackets {

    companion object {

        fun valid11(str: String?): Boolean {

            if (str == "" || str == null) {
                return false
            }

            var stack = Stack<Char>()

            str.let {

                for (c in it.toCharArray()) {

                    if (c == '{') {

                        stack.push('}')
                    } else if (c == '[') {

                        stack.push(']')
                    } else if (c == '(') {
                        stack.push(')')
                    } else if (stack.isEmpty() || stack.pop() != c) {
                        return false
                    }
                }

            }

            return stack.isEmpty()
        }

        fun valid12(str: String?): Boolean {

            if (str == null || str == "") {
                return false
            }

            var stack = Stack<Char>()

            str.let {

                for (c in it.toCharArray()) {

                    if (c == '{') {
                        stack.push('}')
                    } else if (c == '(') {
                        stack.push(')')
                    } else if (c == '[') {
                        stack.push(']')
                    } else if (stack.isEmpty() || c != stack.pop()) {
                        return false
                    }

                }
            }

            return stack.isEmpty()
        }

    }
}

fun main() {

    System.out.println(ValidBrackets.valid11("{{{}}}(())[][]"))
    System.out.println(ValidBrackets.valid11("{{{}}}(())[]["))

    System.out.println(ValidBrackets.valid12("{{{}}}(())[][]"))
    System.out.println(ValidBrackets.valid12("{{{}}}(())[]["))

}