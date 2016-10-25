package leetcode.dfs;

import java.util.*;

/**
 * Created by sunbo_000 on 10/17/2016.
 */

/*
    https://leetcode.com/problems/combination-sum-ii/
 */

public class Combination_Sum_II_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        HashSet<ArrayList<Integer>> tempResult = new HashSet<>();
        dfs(candidates, 0, target, new ArrayList<>(), tempResult);
        result = new ArrayList<>(tempResult);
        return result;
    }

    private void dfs(int[] candidates, int pointer, int target, List<Integer> temp, HashSet<ArrayList<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = pointer; i < candidates.length; i++) {
            if (target < candidates[i]) return;
            temp.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Combination_Sum_II_40 solution = new Combination_Sum_II_40();
        List<List<Integer>> result = solution.combinationSum2(candidates, target);
        String stop = "";
    }
}
