package xwan.leetcode;

/**
 * Created by xwan on 2/26/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParentheses {
    public static List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", n, n);
        return res;
    }
    private static void helper(List<String> res, String s, int left, int right) {
        if (left > right) return;
        if (left > 0) helper(res, s + "(", left - 1, right);
        if (right > 0) helper(res, s + ")", left, right - 1);

        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
    }

    public static void main(String[] args) {
        generateParentheses(4);
    }
}
