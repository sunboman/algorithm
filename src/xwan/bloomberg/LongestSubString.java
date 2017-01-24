package xwan.bloomberg;

/**
 * Created by xwan on 1/6/17.
 */
public class LongestSubString {
    public static String longestSubstring(String s) {
        if (s == null || s.length() < 2) {
            return "";
        }
        String ans = "";
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '#') {
                    count++;
                } else if (s.charAt(j) == '*') {
                    count--;
                }
                if (count == 0) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    // O(n)
    public static String longestSubstring2(String s) {
        if (s == null || s.length() < 2) {
            return "";
        }
        int n = s.length();
        int max = 0;
        String ans = "";
        int count = 0;
        int left = 0;
        int right = 0;
        while (right < n) {

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "*****####*****##";
        System.out.println(longestSubstring(s));
    }
}
