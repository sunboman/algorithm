package xwan.leetcode.bfs_dfs_tree_backtracking;

/**
 * Created by xwan on 12/29/16.
 */
public class WordSearch79 {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j, 0, n, m)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int i, int j, int idx, int n, int m) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i == n || j == m || board[i][j] != word.charAt(idx)) {
            return false;
        }
        board[i][j] = '#';
        boolean exist = helper(board, word, i + 1, j, idx + 1, n, m) ||
                helper(board, word, i - 1, j, idx + 1, n, m) ||
                helper(board, word, i, j - 1, idx + 1, n, m) ||
                helper(board, word, i, j + 1, idx + 1, n, m);

        board[i][j] = word.charAt(idx);
        return exist;
    }
}
