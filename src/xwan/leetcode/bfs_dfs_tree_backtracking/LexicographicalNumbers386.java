package xwan.leetcode.bfs_dfs_tree_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwan on 12/26/16.
 */
public class LexicographicalNumbers386 {
    // solution with dfs
    public static List<Integer> lexicoNums_dfs(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, res);
        }
        return res;
    }

    private static void dfs(int curr, int n, List<Integer> res) {
        if (curr > n) {
            return;
        }
        res.add(curr);
        for (int i = 0; i < 10; i++) {
            if (curr * 10 + i > n) {
                return;
            }
            dfs(curr * 10 + i, n, res);
        }
    }

    // solution with iterative, the basic idea is to find next number to add
    public static List<Integer> lexicoNums_ite(int n) {
        List<Integer> res = new ArrayList<>();
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            res.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
