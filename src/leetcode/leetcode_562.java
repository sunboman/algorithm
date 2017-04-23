package leetcode;

/**
 * Created by bosun on 4/22/17.
 */
public class leetcode_562 {
  int max = 0;

  public int longestLine(int[][] M) {
    int n = M.length, m = M[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if ((M[i][j] & 1) == 1) {
          getLines(M, i, j);
        }
      }
    }
    return max;
  }

  private void getLines(int[][] M, int i, int j) {
    int n = M.length, m = M[0].length;
    if (i < 0 || i >= n || j < 0 || j >= m || M[i][j] == 0 || M[i][j] >> 1 == 15) {
      return;
    }
    int mark = M[i][j] >> 1;
    if ((mark & 1) == 0) {
      int temp = 0;
      for (int k = j; k < m; k++) {
        if (M[i][k] == 0) break;
        M[i][k] |= (1 << 1);
        temp++;
      }
      for (int k = j - 1; k >= 0; k--) {
        if (M[i][k] == 0) break;
        M[i][k] |= (1 << 1);
        temp++;
      }
      max = Math.max(temp, max);
    }
    if ((mark & (1 << 1)) == 0) {
      int temp = 0;
      for (int k = i; k < n; k++) {
        if (M[k][j] == 0) break;
        M[k][j] |= (1 << 2);
        temp++;
      }
      for (int k = i - 1; k >= 0; k--) {
        if (M[k][j] == 0) break;
        M[k][j] |= (1 << 2);
        temp++;
      }
      max = Math.max(temp, max);
    }
    if ((mark & (1 << 3)) == 0) {
      int temp = 0;
      for (int k = i, l = j; k >= 0 && l < m; ) {
        if (M[k][l] == 0) break;
        M[k][l] |= (1 << 3);
        temp++;
        k--;
        l++;
      }
      for (int k = i + 1, l = j - 1; k < n && l >= 0; ) {
        if (M[k][l] == 0) break;
        M[k][l] |= (1 << 3);
        temp++;
        k++;
        l--;
      }
      max = Math.max(temp, max);
    }
    if ((mark & (1 << 4)) == 0) {
      int temp = 0;
      for (int k = i, l = j; k >= 0 && l >= 0; ) {
        if (M[k][l] == 0) break;
        M[k][l] |= (1 << 4);
        temp++;
        k--;
        l--;
      }
      for (int k = i + 1, l = j + 1; k < n && l < m; ) {
        if (M[k][l] == 0) break;
        M[k][l] |= (1 << 4);
        temp++;
        k++;
        l++;
      }
      max = Math.max(temp, max);
    }
  }
  public static void main(String[] args) {

    new leetcode_562().longestLine(new int[][]{
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1}
    });
  }
}
