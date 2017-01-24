package xwan.leetcode.array_numbers_string;

/**
 * Created by xwan on 12/28/16.
 */
public class LongestPalindromicSubstring5 {
    public static String longestPalindrome_ite(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String ans = s.substring(0, 1);
        int max = 1;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            int l = i - 1;
            int r = i;
            while (r + 1 < n && s.charAt(r + 1) == s.charAt(i)) {
                r++;
            }
            while (l >= 0 && s.charAt(l) == s.charAt(i)) {
                l--;
            }
            while (l >= 0 && r + 1 < n && s.charAt(l) == s.charAt(r + 1)) {
                l--;
                r++;
            }
            if (max < r - l) {
                max= r - l;
                ans = s.substring(l + 1, r + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("ab".substring(0, 1));
    }
}
