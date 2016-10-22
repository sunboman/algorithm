/**
 *
 * 64 Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
 *
 * https://leetcode.com/problems/minimum-path-sum/
 *
 */


/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    if(grid === null) return 0;
    var m = grid.length;
    var n = grid[0].length;

    for(var i = 1; i < m; i++) {
        grid[i][0] += grid[i - 1][0];
    }
     for(var j = 1; j < n; j++) {
        grid[0][j] += grid[0][j - 1];
     }

     for(var k = 1; k < m; k++) {
         for(var l = 1; l < n; l++) {
              grid[k][l] += Math.min(grid[k - 1][l], grid[k][l - 1]);
         }
     }
    return grid[m - 1][n - 1];
};