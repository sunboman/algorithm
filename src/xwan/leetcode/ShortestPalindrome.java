package xwan.leetcode;

/**
 * Created by xwan on 2/26/17.
 */

/**
 * 214. Shortest Palindrome
 *
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".
 */

/**
 * solution: KMP
 */
public class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        String str = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(str);
        int idx = table[table.length - 1];
        return new StringBuilder(s.substring(idx)).reverse().toString() + s;
    }

    private static int[] getTable(String s) {
        int[] table = new int[s.length()];
        int idx = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(idx) == s.charAt(i)) {
                table[i] = table[i - 1] + 1;
                idx++;
            } else {
                idx = table[i - 1];
                while (idx > 0 && s.charAt(idx) != s.charAt(i)) {
                    idx = table[idx - 1];
                }
                if (s.charAt(idx) == s.charAt(i)) idx++;
                table[i] = idx;
            }
        }

        return table;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("absbcf"));
    }
}
