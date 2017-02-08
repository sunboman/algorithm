package xwan.audible;

/**
 * Created by xwan on 2/3/17.
 */

/**
 * write a program to find the index of the first non-repeated character in a java string.
 */
public class FirstNonRepeatCharater {
    public static int firstUniqueChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] hash = new int[256];
        for (char ch : s.toCharArray()) {
            hash[ch]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hash[ch] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("leetcode"));
    }
}
