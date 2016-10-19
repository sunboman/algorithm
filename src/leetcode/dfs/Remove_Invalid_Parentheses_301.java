package leetcode.dfs;

import java.util.*;

/**
 * Created by sunbo_000 on 10/18/2016.
 */

/*
    https://leetcode.com/problems/remove-invalid-parentheses
 */
/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

 */

public class Remove_Invalid_Parentheses_301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        if (s == null || s.length() == 0) {
            ret.add(s);
            return ret;
        }

        remove(s, ret, 0, 0, new char[]{'(', ')'});
        return ret;
    }

    private void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }

    public List<String> bfs(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add(s);
            return result;
        }

        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String top = queue.poll();

            if (isValid(top)) {
                found = true;
                result.add(top);
            }

            if (found) continue;

            for (int i = 0; i < top.length(); i++) {
                if (top.charAt(i) != '(' && top.charAt(i) != ')') continue;
                String child = top.substring(0, i) + top.substring(i + 1, top.length());

                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.offer(child);
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }


    public static void main(String[] args) {
        Remove_Invalid_Parentheses_301 solution = new Remove_Invalid_Parentheses_301();
        List<String> result = solution.removeInvalidParentheses("()))");
//        List<String> result2 = solution.bfs("()())()");
        String stop = "";
    }
}
