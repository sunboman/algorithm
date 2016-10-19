/**
 *
 * 46 Permutations
 *
 * Given a collection of distinct numbers, return all possible permutations.

  For example,
  [1,2,3] have the following permutations:
  [
    [1,2,3],
    [1,3,2],
    [2,1,3],
    [2,3,1],
    [3,1,2],
    [3,2,1]
  ]
 *
 *
 * https://leetcode.com/problems/permutations/
 */

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    if(nums.length < 1 || nums === null) return [];
    var result = [],
        temp = [];
    helper(nums);
    return result;

    function helper(nums) {
        for(var i = 0; i < nums.length; i++) {
            if(temp.indexOf(nums[i]) === -1) {
                temp.push(nums[i]);
                if(temp.length === nums.length) {
                    result.push(temp.slice());
                } else {
                    helper(nums);
                }
                temp.pop();
            }
        }
    }
};