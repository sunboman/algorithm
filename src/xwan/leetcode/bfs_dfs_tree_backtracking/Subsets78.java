package xwan.leetcode.bfs_dfs_tree_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwan on 1/15/17.
 */
public class Subsets78 {
    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, res, path, 0);
        return res;
    }

    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> path, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        subset(nums);
    }
}
