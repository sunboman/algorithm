/**
 * 198 House Robber
 *
 *
 *  You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.


 *
 *
 * https://leetcode.com/problems/house-robber/
 * 
 */


/**
 * @param {number[]} nums
 * @return {number}
 */

//solution with DP
var rob_dp = function(nums) {
    var rob = 0; // rob house
    var notRob = 0; // not rob house
    for(var i = 0; i < nums.length; i++) {
        var curr = notRob + nums[i]; // currrob
        notRob = Math.max(notRob, rob);
        rob = curr;
    }
    
    return Math.max(notRob, rob);
};

console.log(rob_dp([])); // 0
console.log(rob_dp([1])); // 1
console.log(rob_dp([1,5])); // 5
console.log(rob_dp([2,1,1,2])); // 4
console.log(rob_dp([2,1,1,4,2,2,2,6])); // 14

var rob = function(nums) {
    var a = 0, b = 0;
    for(var i = 0; i < nums.length; i++) {
        if(i % 2 === 0) a = Math.max(a + nums[i], b);
        else b = Math.max(b + nums[i], a);
    }

    return Math.max(a, b);
};