package xwan.leetcode;

/**
 * Created by xwan on 2/23/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 *
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

 Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

 Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

 Note:
 The order of returned grid coordinates does not matter.
 Both m and n are less than 150.
 Example:

 Given the following 5x5 matrix:

 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

 Return:

 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class PacificAtlanticWater {
    private static final int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        // top and left most water can flow to pacific, bottom and right most can flow to atlantic
        for (int i = 0; i < n; i++) {
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        for (int j = 0; j < m; j++) {
            pacific[0][j] = true;
            atlantic[n - 1][j] = true;
        }
        for (int i = 0; i < n; i++) {
            fill(pacific, matrix, i, 0);
            fill(atlantic, matrix, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            fill(pacific, matrix, 0, j);
            fill(atlantic, matrix, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }
    private void fill(boolean[][] grid, int[][] matrix, int i, int j) {
        grid[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int x = i + dirs[d][0];
            int y = j + dirs[d][j];
            if (isValid(x, y, i, j, matrix) && !grid[x][y]) {
                fill(grid, matrix, x, y);
            }
        }
    }
    private boolean isValid(int x, int y, int i, int j, int[][] matrix) {
        if (x >= 0 && x < matrix.length &&
                y >= 0 && y < matrix[0].length &&
                matrix[x][y] >= matrix[i][j]) {
            return true;
        }
        return false;
    }

}
