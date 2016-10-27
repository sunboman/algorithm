/**
 * 81 Search in Rotated Sorted Array II
 *
 * Follow up for "Search in Rotated Sorted Array":
  What if duplicates are allowed?

  Would this affect the run-time complexity? How and why?

  Write a function to determine if a given target is in the array.
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 */
var search = function(nums, target) {
    if (nums === null || nums.length === 0) {
      return false;
    }
    for (var i = 0; i < nums.length; i++) {
      if (nums[i] === target) {
        return true;
      }
    }
    return false;
};