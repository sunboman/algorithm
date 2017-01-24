package xwan.leetcode.binary_search_divide_conquer;

/**
 * Created by xwan on 12/31/16.
 */
public class FactorialTrailingZeroes172 {
    public static int trailingZeros(int n) {
        int count = 0;
        while (n != 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeros(10)); // 2
        System.out.println(trailingZeros(100)); // 24
    }
}
