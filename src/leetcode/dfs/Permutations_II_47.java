package leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            Set<ArrayList<Integer>> current = new HashSet<>();
            for (List<Integer> permution : result) {
                for (int j = 0; j < permution.size() + 1; j++) {
                    permution.add(j, nums[i]);
                    ArrayList<Integer> list = new ArrayList<>(permution);
                    permution.remove(j);
                    current.add(list);
                }
            }
            result = new ArrayList<>(current);
        }

        return result;
    }



    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        Permutations_II_47 solution = new Permutations_II_47();
        List<List<Integer>> result = solution.permuteUnique(nums);
        String a = "";
    }


}
