package leetcode.binary_search;

/**
 * Created by sunbo_000 on 10/14/2016.
 */

/*
    https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Search_a_2D_Matrix_II_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix[0].length - 1;
        int n = 0;
        while (n < matrix.length && m >= 0) {
            if (matrix[n][m] == target) return true;
            else if (matrix[n][m] > target) m--;
            else n++;
        }
        return false;

    }


    public static void main(String[] args) {
        Search_a_2D_Matrix_II_240 solution = new Search_a_2D_Matrix_II_240();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7, 9},
                {2, 4, 6, 8, 10},
                {11, 13, 15, 17, 19},
                {12, 14, 16, 18, 20},
                {21, 22, 23, 24, 25}
        };
        /*int[][] matrix = new int[][]{
                {1, 1}
        };*/
        System.out.println(solution.searchMatrix(matrix, 8));
    }
}
