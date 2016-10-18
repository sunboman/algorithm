package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        List<Character> left = new ArrayList(Arrays.asList(new Character[]{'(', '{', '['}));
        for (int i = 0; i < s.length(); i++) {
            if (left.contains(s.charAt(i))) st.push(s.charAt(i));
            else {
                if (!validate(st.pop(), s.charAt(i))) return false;
            }
        }
        return st.empty();
    }

    boolean validate(Character a, Character b) {
        if (a == null || b == null) return false;
        switch (a) {
            case '(':
                return b.equals(')');
            case '{':
                return b.equals('}');
            case '[':
                return b.equals(']');
            default:
                return false;

        }
    }

    public static void main(String[] args) {
        Valid_Parentheses_20 solution = new Valid_Parentheses_20();
        solution.isValid("[");
    }
}