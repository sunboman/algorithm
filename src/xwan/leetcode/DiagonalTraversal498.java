package xwan.leetcode;

/**
 * Created by xwan on 2/6/17.
 */
public class DiagonalTraversal498 {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n * m];
        int row = 0;
        int col = 0;
        for (int i = 0; i < n * m; i++) {
            res[i] = matrix[row][col];
            if ((row + col) % 2 == 0) {
                if (row > 0 && col < m - 1) {
                    row--;
                    col++;
                } else if (col == m - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                if (row < n - 1 && col > 0) {
                    row++;
                    col--;
                } else if (row == n - 1) {
                    col++;
                } else {
                    row++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        findDiagonalOrder(matrix);
    }
}
