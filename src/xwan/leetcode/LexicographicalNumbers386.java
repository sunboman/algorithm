package xwan.leetcode;

/**
 * Created by xwan on 3/2/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 386. Lexicographical Numbers
 *
 * Given an integer n, return 1 - n in lexicographical order.

 For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

 Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */
public class LexicographicalNumbers386 {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            helper(i, n, res);
        }
        return res;
    }
    private static void helper(int curr, int n, List<Integer> res) {
        if (curr > n) return;
        res.add(curr);
        for (int i = 0; i < 10; i++) {
            if (curr * 10 + i > n) return;
            helper(curr * 10 + i, n, res);
        }
    }

    public static void main(String[] args) {
        lexicalOrder(15);
    }
}
