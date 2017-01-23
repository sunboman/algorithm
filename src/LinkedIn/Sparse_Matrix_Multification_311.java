package LinkedIn;

/**
 * Created by sunbo on 12/30/2016.
 */
/*
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 */
public class Sparse_Matrix_Multification_311 {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int l = B.length;
        int m = B[0].length;
        int[][] C = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < l; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    if (B[k][j] == 0) {
                        continue;
                    }
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1, 0, 0},
                {-1, 0, 3}
        };
        int[][] B = new int[][]{
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        int[][] res = new Sparse_Matrix_Multification_311().multiply(A, B);
        
    }
}
