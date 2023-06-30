package jv.leet.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBracket {

    public static void main(String[] args) {

    }

    private boolean isValid(String str) {

        if (str == null || str.isEmpty()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> result = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            // 说明不是 右括号
            if (!map.containsKey(c)) {
                result.push(c);
            } else {

                if (result.isEmpty()) {
                    return false;
                }

                Character left = result.pop();
                if (!left.equals(map.get(c))) {
                    return false;
                }
            }

        }
        return result.isEmpty();
    }

    private boolean isValid2(String str) {

        if (str == null || str.isEmpty()) {
            return false;
        }

        Map<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');

        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char current = str.charAt(i);

            // 表示左括号
            if (!charMap.containsKey(current)) {
                charStack.add(current);
            } else {
                if (charStack.isEmpty()) {
                    return false;
                }

                Character pop = charStack.pop();

                if (!charMap.get(current).equals(pop)) {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }
}
