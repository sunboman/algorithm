package xwan.leetcode.array_numbers_string;

/**
 * Created by xwan on 12/28/16.
 */
public class String2Integer8 {
    public static int myAtoi(String str) {
        // 1. Empty string
        if (str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int idx = 0;
        long num = 0;
        int n = str.length();
        // 2. Remove spaces
        while (idx < n && str.charAt(idx) == ' ') {
            idx++;
        }
        // 3. handle sign
        if (idx < n &&
                (str.charAt(idx) == '+' || str.charAt(idx) == '-')) {
            sign = str.charAt(idx) == '+' ? 1 : -1;
            idx++;
        }
        // 4. convert to number and avoid overflow
        while (idx < n) {
            int digit = str.charAt(idx) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            num = num * 10 + digit;
            if (num > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            idx++;
        }
        return (int) num * sign;
    }
    public static void main(String[] args) {
        System.out.println("a4".charAt(0) - '0');
    }
}
