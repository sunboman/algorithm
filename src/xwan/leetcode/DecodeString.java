package xwan.leetcode;

import java.util.Stack;

/**
 * Created by xwan on 2/21/17.
 */
public class DecodeString {
    public static String decodeString(String s) {
        String res = "";
        int idx = 0;
        Stack<Integer> countStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                strStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                int k = countStack.pop();
                res = strStack.pop() + expandStrs(k, res);
                idx++;
            } else {
                res += s.charAt(idx);
                idx++;
            }
        }
        return res;
    }

    private static String expandStrs(int k, String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < k; i++) {
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        decodeString("10[a]2[bc]");
    }
}
