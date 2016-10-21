/**
 *
 * 41 First Missing Positive
 *
 * Given an unsorted integer array, find the first missing positive integer.

  For example,
  Given [1,2,0] return 3,
  and [3,4,-1,1] return 2.

  Your algorithm should run in O(n) time and uses constant space.

 *
 *
 * https://leetcode.com/problems/first-missing-positive/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
    var len = nums.length;
    for(var i = 0; i < len; i++) {
        while(nums[i] !== i + 1) {
            // no swap when ith element is out of range
            if(nums[i] <= 0 || nums[i] >= len) break;

            // handle duplicates
            if(nums[i] === nums[nums[i] - 1]) break;

            // swap elements
            var temp = nums[i];
            nums[i] = nums[temp - 1];
            nums[temp - 1] = temp;

        }
    }
    for(var j = 0; j < len; j++) {
        if(nums[j] !== j + 1) return j + 1;
    }
    return len + 1;
};