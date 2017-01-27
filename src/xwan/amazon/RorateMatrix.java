package xwan.amazon;

/**
 * Created by xwan on 1/24/17.
 */

/**
 * You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).

    Follow up: in place and anti-clockwise


 */
public class RorateMatrix {
    // anti-clock
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        print(matrix);
    }
    private static void reverse(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void print(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // rotate clock
    public static void rotate_clock(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - j - 1] = temp;
            }
        }
        print(matrix);
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        rotate(matrix);
        System.out.println("-------------------------");
        rotate_clock(matrix);
    }
}
