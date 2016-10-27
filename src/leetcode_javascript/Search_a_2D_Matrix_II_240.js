/**
 * 240 Search a 2D Matrix II
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

  Integers in each row are sorted in ascending from left to right.
  Integers in each column are sorted in ascending from top to bottom.
  For example,

  Consider the following matrix:

  [
    [1,   4,  7, 11, 15],
    [2,   5,  8, 12, 19],
    [3,   6,  9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
  ]
  Given target = 5, return true.

  Given target = 20, return false.
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if (matrix === null || matrix.length === 0 || matrix[0].length === 0) {
        return false;
    }
    var m = 0;
    var n = matrix[0].length - 1;
    while (m < matrix.length && n >= 0) {
        if (matrix[m][n] === target) {
            return true;
        }
        if (matrix[m][n] > target) {
            n--;
        } else {
            m++;
        }
    }
    return false;
};