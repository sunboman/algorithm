package Amazon_OA;

import java.util.Arrays;

public class Longest_Palindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int res = 0;
        boolean flag = false;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count % 2 == 0) {
                    res += count;
                } else {
                    flag = true;
                    res += (count - 1);
                }
                count = 1;
            }
        }
        if (count % 2 == 0) {
            res += count;
        } else {
            flag = true;
            res += (count - 1);
        }
        if (flag) {
            res++;
        }
        return res;
    }
    public static void main(String[] args) {
        new Longest_Palindrome().longestPalindrome("abccccdd");
    }
}