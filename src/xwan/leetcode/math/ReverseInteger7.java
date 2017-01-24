package xwan.leetcode.math;

/**
 * Created by xwan on 12/26/16.
 */
public class ReverseInteger7 {
    public static int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        }
        long res = 0;
        while (x > 0) {
            res = res * 10 + (x % 10);
            if (res > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }

        return (int) res * sign;
    }

    public static void main(String[] args) {
        reverse(-2147483648); // 0
    }

}
