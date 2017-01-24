package xwan.leetcode.two_pointers;

/**
 * Created by xwan on 12/27/16.
 */
public class LongestSubstring3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] hash = new int[256];
        int maxLen = 1;
        int j = 1;
        int n = s.length();
        hash[s.charAt(0) - 0]++;
        for (int i = 0; i < n; i++) {
            while (j < n && hash[s.charAt(j) - 0] == 0) {
                hash[s.charAt(j++) - 0]++;
            }
            hash[s.charAt(i) - 0]--;
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbddsfdg")); // 4
    }
}
