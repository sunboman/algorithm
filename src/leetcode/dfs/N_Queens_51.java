package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunbo_000 on 10/17/2016.
 */
public class N_Queens_51 {

    private int N;
    private boolean[] vertical;
    private boolean[] left_angle;
    private boolean[] right_angle;


    public List<List<String>> solveNQueens(int n) {
        N = n;
        vertical = new boolean[n];
        left_angle = new boolean[2 * n - 1];
        right_angle = new boolean[2 * n - 1];
        List<List<String>> result = new ArrayList<>();
        dfs(0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int row, List<String> temp, List<List<String>> result) {
        for (int col = 0; col < N; col++) {
            int i = col + row, j = N - 1 + col - row;
            char[] str = new char[N];
            Arrays.fill(str, '.');
            if (vertical[col] || left_angle[i] || right_angle[j]) {
                continue;
            }
            str[col] = 'Q';
            temp.add(new String(str));
            if (row == N - 1) {
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            } else {
                vertical[col] = left_angle[i] = right_angle[j] = true;
                dfs(row + 1, temp, result);
                temp.remove(temp.size() - 1);
                vertical[col] = left_angle[i] = right_angle[j] = false;
            }
        }

    }

    public static void main(String[] args) {
        N_Queens_51 solution = new N_Queens_51();
        List<List<String>> result = solution.solveNQueens(4);
        String a = "";
    }
}
