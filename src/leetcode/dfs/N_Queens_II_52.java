package leetcode.dfs;

/**
 * Created by sunbo_000 on 10/17/2016.
 */
public class N_Queens_II_52 {
    private int N;
    private boolean[] vertical;
    private boolean[] left_angle;
    private boolean[] right_angle;
    private int count;

    public int totalNQueens(int n) {
        N = n;
        count = 0;
        vertical = new boolean[n];
        left_angle = new boolean[2 * n - 1];
        right_angle = new boolean[2 * n - 1];
        dfs(0);
        return count;
    }


    private void dfs(int row) {
        for (int col = 0; col < N; col++) {
            int i = col + row, j = N - 1 + col - row;
            if (vertical[col] || left_angle[i] || right_angle[j]) {
                continue;
            }
            if (row == N - 1) {
                count++;
            } else {
                vertical[col] = left_angle[i] = right_angle[j] = true;
                dfs(row + 1);
                vertical[col] = left_angle[i] = right_angle[j] = false;
            }
        }

    }

    public static void main(String[] args) {
        N_Queens_II_52 solution = new N_Queens_II_52();
        System.out.println(solution.totalNQueens(4));
    }
}
