package leetcode.dfs;

/**
 * Created by sunbo_000 on 10/17/2016.
 */

/*
    https://leetcode.com/problems/combination-sum-iii/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * <p>
 * Output:
 * <p>
 * [[1,2,4]]
 * <p>
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * <p>
 * Output:
 * <p>
 * [[1,2,6], [1,3,5], [2,3,4]]
 */

public class Combination_Sum_III_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k < 0 || k > 9 || n < 1 || n > 55) return result;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(nums, 0, k, n, new ArrayList<>(k), result);
        return result;
    }

    private void dfs(int[] nums, int pointer, int left, int target, List<Integer> temp, List<List<Integer>> result) {
        if (left < 0) return;
        if (target == 0 && left == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = pointer; i < nums.length; i++) {
            if (target < nums[i]) return;
            temp.add(nums[i]);
            dfs(nums, i + 1, left - 1, target - nums[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination_Sum_III_216 solution = new Combination_Sum_III_216();
        List<List<Integer>> result = solution.combinationSum3(2, 18);
        String stop = "";
    }

}
