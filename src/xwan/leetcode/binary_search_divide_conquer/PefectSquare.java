package xwan.leetcode.binary_search_divide_conquer;

/**
 * Created by xwan on 2/10/17.
 */

/**
 * 367. Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

     Note: Do not use any built-in library function such as sqrt.

     Example 1:

     Input: 16
     Returns: True
     Example 2:

     Input: 14
     Returns: False
 */
public class PefectSquare {
    public static boolean isPerfectSquare(int num) {
        long lo = 1;
        long hi = num;
        while (lo + 1 < hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (lo * lo == num) {
            return true;
        }
        if (hi * hi == num) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        isPerfectSquare(808201);
        System.out.println(Math.sqrt(808201));
    }
}
