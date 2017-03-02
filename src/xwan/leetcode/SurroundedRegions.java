package xwan.leetcode;

/**
 * Created by xwan on 2/28/17.
 */

/**
 * 130. Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class SurroundedRegions {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int n = board.length;
        int m = board[0].length;
        print(board);
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') helper(board, i, 0);
            if (board[i][m - 1] == 'O') helper(board, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') helper(board, 0, j);
            if (board[n - 1][j] == 'O') helper(board, n - 1, j);
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
        print(board);
    }
    private static void helper(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'X' || board[i][j] == '#') return;
        board[i][j] = '#';
        if (i + 1 < board.length) helper(board, i + 1, j);
        if (i - 1 >= 0) helper(board, i - 1, j);
        if (j + 1 < board[0].length) helper(board, i, j + 1);
        if (j - 1 >= 0) helper(board, i, j - 1);
    }
    private static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("========================");
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
    }
}
