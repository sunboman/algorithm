/**
 *
 * 47 Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

  For example,
  [1,1,2] have the following unique permutations:
  [
    [1,1,2],
    [1,2,1],
    [2,1,1]
  ]

 *
 *  https://leetcode.com/problems/permutations-ii/
 */

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
    if(nums.length < 1 || nums === null) return [];
    var res = [],
        temp = [],
        visits = [];
    nums.sort((a, b) => (a - b));
    helper(nums);
    return res;

    function helper(nums) {
        if(temp.length === nums.length) {
            res.push(temp.slice());
            return;
        }
        for(var i = 0; i < nums.length; i++) {
            if(!visits[i]) {
                if(i > 0 && nums[i] === nums[i - 1] && visits[i - 1]) {
                    continue;
                }
                visits[i] = true;
                temp.push(nums[i]);
                helper(nums);
                temp.pop();
                visits[i] = false;
            }
        }
    }
};