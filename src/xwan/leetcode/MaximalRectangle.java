package xwan.leetcode;

/**
 * Created by xwan on 2/20/17.
 */

import java.util.Stack;

/**
 * 85. Maximal Rectangle
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 6.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            updateHeights(heights, matrix, i);
            max = Math.max(max, maxInline(heights));
        }
        return max;
    }
    private void updateHeights(int[] heights, char[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] == '1') {
                heights[i] += 1;
            } else heights[i] = 0;
        }
    }
    private int maxInline(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, top * w);
                i--;
            }
        }
        return maxArea;
    }
}
