package xwan.leetcode.binary_search_divide_conquer;

/**
 * Created by xwan on 2/10/17.
 */

/**
 * 441. Arranging Coins
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

     Given n, find the total number of full staircase rows that can be formed.

     n is a non-negative integer and fits within the range of a 32-bit signed integer.

     Example 1:

     n = 5

     The coins can form the following rows:
     ¤
     ¤ ¤
     ¤ ¤

     Because the 3rd row is incomplete, we return 2.
     Example 2:

     n = 8

     The coins can form the following rows:
     ¤
     ¤ ¤
     ¤ ¤ ¤
     ¤ ¤

     Because the 4th row is incomplete, we return 3.
 */
public class ArrangCoin {
    public static int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        int lo = 1;
        int hi = n;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if ((0.5 * mid * mid + 0.5 * mid) <= n) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (hi * (hi + 1) / 2 >= n) {
            return lo;
        } else {
            return hi - 1;
        }
    }

    public static void main(String[] args) {
//        System.out.println(arrangeCoins(8));
//        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(1804289383));
    }
}
