package xwan.linkedin;

/**
 * Created by xwan on 2/14/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 254. Factor Combinations
 *
 * Numbers can be regarded as product of its factors. For example,

     8 = 2 x 2 x 2;
     = 2 x 4.
     Write a function that takes an integer n and return all possible combinations of its factors.

     Note:
     You may assume that n is always positive.
     Factors should be greater than 1 and less than n.
     Examples:
     input: 1
     output:
     []
     input: 37
     output:
     []
     input: 12
     output:
     [
     [2, 6],
     [2, 2, 3],
     [3, 4]
     ]
     input: 32
     output:
     [
     [2, 16],
     [2, 2, 8],
     [2, 2, 2, 4],
     [2, 2, 2, 2, 2],
     [2, 4, 4],
     [4, 8]
     ]
 */
public class FactorCombination {
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();

        helper(n, res, new ArrayList<Integer>(), 2);
        return res;
    }
    private static void helper(int n, List<List<Integer>> res, List<Integer> tmp, int start) {
        if (n <= 1) {
            if (tmp.size() > 1) {
                res.add(new ArrayList<Integer>(tmp));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                tmp.add(i);
                helper(n / i, res, tmp, i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        getFactors(32);
    }
}
