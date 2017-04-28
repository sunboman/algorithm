package leetcode;

/**
 * Created by bosun on 4/28/17.
 */
public class Kth_Smallest_In_Sorted_Matrix_378 {
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int count = getCount(matrix, mid);
      if (count < k) lo = mid + 1;
      else hi = mid - 1;
    }
    return lo;
  }

  private int getCount(int[][] matrix, int val) {
    int n = matrix.length;
    int i = n - 1, j = 0;
    int res = 0;
    while (j < n) {
      while (i >= 0 && matrix[i][j] > val) {
        i--;
      }
      res += (i + 1);
      j++;
    }
    return res;
  }

  public static void main(String[] args) {
    new Kth_Smallest_In_Sorted_Matrix_378().kthSmallest(new int[][]{{-5}}, 1);
  }
}
