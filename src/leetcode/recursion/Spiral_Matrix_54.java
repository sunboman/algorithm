package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbo_000 on 10/15/2016.
 */

/*
    https://leetcode.com/problems/spiral-matrix/
 */

public class Spiral_Matrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();
        List<Integer> spiral = new ArrayList<>();
        spiral(matrix, 0, spiral);
        return spiral;
    }

    private void spiral(int[][] matrix, int index, List<Integer> spiral) {
        int m = matrix[0].length;
        int n = matrix.length;
        if (m - 1 - index < index || n - 1 - index < index) return;
        /*if (m - 1 - index == index) {
            for (int i = index; i < n - index; i++) {
                spiral.add(matrix[i][index]);
            }
            return;
        } else if (n - 1 - index == index) {
            for (int i = index; i < m - index; i++) {
                spiral.add(matrix[index][i]);
            }
            return;
        }*/

        for (int i = index; i < m - index; i++) {
            spiral.add(matrix[index][i]);
        }
        for (int i = index + 1; i < n - index; i++) {
            spiral.add(matrix[i][m - index - 1]);
        }
        if (index <= n / 2 - 1) {
            for (int i = m - 2 - index; i >= index; i--) {
                spiral.add(matrix[n - index - 1][i]);
            }
        }
        if (index <= m / 2 - 1) {
            for (int i = n - index - 2; i > index; i--) {
                spiral.add(matrix[i][index]);
            }
        }
        index++;
        spiral(matrix, index, spiral);
    }

    public static void main(String[] args) {
        Spiral_Matrix_54 solution = new Spiral_Matrix_54();
        int[][] nums = new int[][]{
             /*   {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}*/
                {1},
                {2},
                {3}
        };
        solution.spiralOrder(nums);
    }
}
