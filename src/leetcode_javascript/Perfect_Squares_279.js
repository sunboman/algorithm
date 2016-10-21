/**
 *
 * 279 Perfect Squares
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

  For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.


 *
 * https://leetcode.com/problems/perfect-squares/
 */

/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
    if(n <= 0) return 0;
    var dp = [];
    for(var i = 0; i <= n; i++) {
        dp[i] = i;
        for(var j = 1; j * j <= i; j++) {
            dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
    }

    return dp[n];
};