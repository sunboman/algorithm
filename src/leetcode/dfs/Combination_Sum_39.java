package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunbo_000 on 10/17/2016.
 */
public class Combination_Sum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int pointer, int target, List<Integer> temp, List<List<Integer>> result) {


        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pointer; i < candidates.length; i++) {
            if (target < candidates[i]) return;
            temp.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination_Sum_39 solution = new Combination_Sum_39();
        int[] candidates = {1, 2};
        int target = 4;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
    }
}
