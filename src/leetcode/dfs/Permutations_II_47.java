package leetcode.dfs;

import java.util.*;

/**
 * Created by sunbo_000 on 10/17/2016.
 */

/*
    https://leetcode.com/problems/permutations-ii/
 */

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Permutations_II_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, new ArrayList<Integer>(), result, visited);
        return result;
    }

    private void dfs(int[] nums, List<Integer> temp, List<List<Integer>> result, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1])) {
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            dfs(nums, temp, result, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }

    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        Permutations_II_47 solution = new Permutations_II_47();
        List<List<Integer>> result = solution.permuteUnique(nums);
    }


}
