package xwan.leetcode.data_structure;

import java.util.Stack;

/**
 * Created by xwan on 12/26/16.
 */
public class ValidParentheses20 {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> left = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left.push(')');
            } else if (ch == '[') {
                left.push(']');
            } else if (ch == '{') {
                left.push('}');
            } else if (left.isEmpty() || ch != left.pop()) {
                return false;
            }
        }
        return left.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}]["));
    }
}
