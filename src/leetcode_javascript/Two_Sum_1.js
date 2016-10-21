/**
 *
 * 1 Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

  You may assume that each input would have exactly one solution.

  Example:
  Given nums = [2, 7, 11, 15], target = 9,

  Because nums[0] + nums[1] = 2 + 7 = 9,
  return [0, 1].
  UPDATE (2016/2/13):
  The return format had been changed to zero-based indices. Please read the above updated description carefully.

 * https://leetcode.com/problems/two-sum/
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    if(nums.length < 2) return null;
    var map = [];
    var res = [];
    for(var i = 0; i < nums.length; i++) {
        if(map.length > 0 && map.indexOf(nums[i]) !== -1) {
            res.push(map.indexOf(nums[i]));
            res.push(i);
            return res;
        } else {
            map.push(target - nums[i]);
        }
    }
    return res;
};