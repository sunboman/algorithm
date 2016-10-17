/**
 *
 * 179 Largest Number
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.

  For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

  Note: The result may be very large, so you need to return a string instead of an integer.


 *
 *
 * https://leetcode.com/problems/largest-number/
 */

/**
 * @param {number[]} nums
 * @return {string}
 */
var largestNumber = function(nums) {
    if(nums.length < 1) return null;

    var result = nums.sort(sortFunc).join("");
    return parseInt(result) === 0 ? '0' : result;

    function sortFunc(a, b) {
        var aStr = a.toString();
        var bStr = b.toString();
        return ((bStr + aStr) - (aStr + bStr));
    }
};