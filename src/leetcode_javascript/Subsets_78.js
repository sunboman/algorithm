/**
 * 78 Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets.

  Note: The solution set must not contain duplicate subsets.

  For example,
  If nums = [1,2,3], a solution is:

  [
    [3],
    [1],
    [2],
    [1,2,3],
    [1,3],
    [2,3],
    [1,2],
    []
  ]
 *
 * https://leetcode.com/problems/subsets/
 */

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    var results = [];
    if (nums === null || nums.length === 0) {
        return results;
    }
    var temp = [];
    subsetsHelper(nums, 0, temp, results);
    return results;

    function subsetsHelper(nums, startIdx, temp, results) {
        results.push(temp.slice());
        for (var i = startIdx; i < nums.length; i++) {
            temp.push(nums[i]);
            subsetsHelper(nums, i + 1, temp, results);
            temp.pop();
        }
    }
};