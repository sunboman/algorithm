package xwan.leetcode.binary_search_divide_conquer;

/**
 * Created by xwan on 12/26/16.
 */
public class Sqrtx69 {
    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
                if ((start + 1) * (start + 1) > x) {
                    break;
                }
            } else {
                end = mid;
            }
        }

        return (int) start;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(5));
    }
}
