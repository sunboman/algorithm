package leetcode.binary_search;

/**
 * Created by sunbo_000 on 10/14/2016.
 */

/*
    https://leetcode.com/problems/search-a-2d-matrix/
 */

public class Search_a_2D_Matrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int length = matrix[0].length;
        int width = matrix.length;

        int low = 0;
        int high = length * width - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = matrix[mid / length][mid % length];
            if (midVal < target) low = mid + 1;
            else if (midVal > target) high = mid - 1;
            else return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Search_a_2D_Matrix_74 solution = new Search_a_2D_Matrix_74();
        /*int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };*/
        int[][] matrix = new int[][]{
                {1}
        };
        System.out.println(solution.searchMatrix(matrix, 1));
    }
}
