package xwan.leetcode;

/**
 * Created by xwan on 2/27/17.
 */

import java.util.Stack;

/**
 * 316. Remove Duplicate Letters
 *
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 Example:
 Given "bcabc"
 Return "abc"

 Given "cbacdcbc"
 Return "acdb"
 */
public class RemoveDupLetters {
    public static String removeDupLetters(String s) {
        if (s == null || s.length() < 2) return s;
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) hash[ch - 'a']++;

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            int currIdx = ch - 'a';
            hash[currIdx]--;
            while (!stack.isEmpty() && ch < stack.peek() && hash[stack.peek() - 'a'] != 0 && !visited[currIdx]) {
                visited[stack.pop() - 'a'] = false;
            }

            if (!visited[currIdx]) stack.push(ch);
            visited[currIdx] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) sb.insert(0, stack.pop());

        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(removeDupLetters("cbacdcbc"));
        System.out.println(removeDupLetters("abacb"));
    }
}
