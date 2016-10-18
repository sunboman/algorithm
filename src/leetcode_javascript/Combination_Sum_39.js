/**
 *
 * 39 Combination Sum
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

  The same repeated number may be chosen from C unlimited number of times.

  Note:
  All numbers (including target) will be positive integers.
  The solution set must not contain duplicate combinations.
  For example, given candidate set [2, 3, 6, 7] and target 7,
  A solution set is:
  [
    [7],
    [2, 2, 3]
  ]
 *
 *
 * https://leetcode.com/problems/combination-sum/
 */

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    if(candidates.length < 1 || candidates === null) return [];
    var result = [];
    var temp = [];
    candidates.sort((a, b) => a - b);
    dfs(0, target);
    return result;

    function dfs(startIdx, target) {
       if(target === 0) result.push(temp.slice());
       if(target < 0) return;
       if(startIdx === candidates.length) return;
       for(var i = startIdx; i < candidates.length; i++) {
           temp.push(candidates[i]);
           dfs(i, target - candidates[i]);
           temp.pop();
       }
    }
};