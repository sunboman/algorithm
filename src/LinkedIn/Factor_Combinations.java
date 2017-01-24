package LinkedIn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbo on 12/30/2016.
 */
/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
 */
public class Factor_Combinations {
    public List<List<Integer>> getFactors(int n) {
        if (n == 1) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(2, 1, n, new ArrayList<>(), res);
        return res;
    }

    private void helper(int start, int product, int n, List<Integer> path, List<List<Integer>> res) {
        if (start > n || product > n) {
            return;
        }
        if (product == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for  (int i = start; i < n; i++) {
            if (i * start > n) {
                break;
            }
            if (n % i == 0) {
                path.add(i);
                helper(i, i * product, n, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Factor_Combinations().getFactors(16);
    }
}
