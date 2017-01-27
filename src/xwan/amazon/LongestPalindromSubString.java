package xwan.amazon;

/**
 * Created by xwan on 1/26/17.
 */

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 *
 * Example
    Given the string = "abcdzdcab", return "cdzdc".
 */
public class LongestPalindromSubString {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String res = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String currLongest = getExpandString(s, i, i);
            if (currLongest.length() > res.length()) {
                res = currLongest;
            }

            currLongest = getExpandString(s, i, i + 1);
            if (currLongest.length() > res.length()) {
                res = currLongest;
            }
        }
        return res;
    }

    private static String getExpandString(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdzdcbaab"));
    }
}
