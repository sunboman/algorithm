package xwan.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xwan on 3/19/17.
 */

/**
 *
 * 542. 01 Matrix
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

 The distance between two adjacent cells is 1.
 Example 1:
 Input:

 0 0 0
 0 1 0
 0 0 0
 Output:
 0 0 0
 0 1 0
 0 0 0
 Example 2:
 Input:

 0 0 0
 0 1 0
 1 1 1
 Output:
 0 0 0
 0 1 0
 1 2 1
 Note:
 The number of elements of the given matrix will not exceed 10,000.
 There are at least one 0 in the given matrix.
 The cells are adjacent in only four directions: up, down, left and right.
 */
public class Matrix01542 {
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int n = matrix.size();
        if (n == 0) return matrix;
        int m = matrix.get(0).size();
        if (m == 0) return matrix;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) queue.offer(new int[]{i, j});
                else {
                    matrix.get(i).set(j, Integer.MAX_VALUE);
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int d = 0; d < 4; d++) {
                int x = curr[0] + dirs[d][0];
                int y = curr[1] + dirs[d][1];
                if (x < 0 || x >= n || y < 0 || y >= m ||
                        matrix.get(x).get(y) <= matrix.get(curr[0]).get(curr[1]) + 1) continue;
                queue.offer(new int[]{x, y});
                matrix.get(x).set(y, matrix.get(curr[0]).get(curr[1]) + 1);
            }
        }

        return matrix;
    }
}
