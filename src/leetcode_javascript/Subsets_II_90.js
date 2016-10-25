/**
 * 90 Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

  Note: The solution set must not contain duplicate subsets.

  For example,
  If nums = [1,2,2], a solution is:

  [
    [2],
    [1],
    [1,2,2],
    [2,2],
    [1,2],
    []
  ]
 *
 * https://leetcode.com/problems/subsets-ii/
 */

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    if (nums === null || nums.length === 0) {
        return [];
    }
    var results = [];
    var temp = [];
    nums.sort((a, b) => a - b);
    subsetsWithDupHelper(nums, 0, temp, results);
    return results;

    function subsetsWithDupHelper(nums, startIdx, temp, results) {
        results.push(temp.slice());
        for (var i = startIdx; i < nums.length; i++) {
            temp.push(nums[i]);
            subsetsWithDupHelper(nums, i + 1, temp, results);
            temp.pop();
            while (i + 1 < nums.length && nums[i] === nums[i + 1]) {
                i++;
            }
        }
    }
};