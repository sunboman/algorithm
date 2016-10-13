package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunbo_000 on 10/12/2016.
 */

/*
    https://leetcode.com/problems/subsets/
 */
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int pos, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = pos; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets_78 solution = new Subsets_78();
        int[] nums = new int[]{1, 2, 3};
        solution.subsets(nums);
    }
}
