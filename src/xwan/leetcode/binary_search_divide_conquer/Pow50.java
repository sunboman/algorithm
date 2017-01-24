package xwan.leetcode.binary_search_divide_conquer;

/**
 * Created by xwan on 12/26/16.
 */
public class Pow50 {
    public static double myPow(double x, int n) {
        if (x == 1 || n <= Integer.MIN_VALUE && x < 0 || n == 0) {
            return 1;
        }
        if (n <= Integer.MIN_VALUE && x > 0 || x == 0) {
            return 0;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, n / 2);
        }
    }
    public static void main(String[] args) {
        System.out.println(Math.pow(2,-3));
    }
}
