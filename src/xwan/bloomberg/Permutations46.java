package xwan.bloomberg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwan on 1/2/17.
 */
public class Permutations46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        helper(nums, path, res);
        return res;
    }

    private static void helper(int[] nums, List<Integer> path, List<List<Integer>> res) {
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            if (path.size() == nums.length) {
                res.add(new ArrayList<Integer>(path));
            } else {
                helper(nums, path, res);
            }
            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
    }
}