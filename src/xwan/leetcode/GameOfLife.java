package xwan.leetcode;

/**
 * Created by xwan on 2/27/17.
 */

/**
 * 289. Game of Life
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

 Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 Write a function to compute the next state (after one update) of the board given its current state.

 Follow up:
 1. Could you solve it in-place? Remember that the board needs to be updated at the same time:
 You cannot update some cells first and then use their updated values to update other cells.

 2. In this question, we represent the board using a 2D array. In principle, the board is infinite,
 which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class GameOfLife {
    private static final int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
    public static void gameOfLife(int[][] board) {
        print(board);
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int lives = countLives(board, i, j);
                if (board[i][j] == 0 && lives == 3) board[i][j] = 3;
                if (board[i][j] == 1 && (lives < 2 || lives > 4)) board[i][j] = 2;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] %= 2;
            }
        }
        System.out.println("=========================");
        print(board);
    }
    private static int countLives(int[][] board, int i, int j) {
        int lives = 0;
        for (int d = 0; d < 8; d++) {
            int x = i + dirs[d][0];
            int y = j + dirs[d][1];
            if (isValid(board, x, y) && (board[x][y] == 1 || board[x][y] == 2)) lives++;
        }
        return lives;
    }

    private static boolean isValid(int[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        return true;
    }

    private static void print(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0,1,0},{1,0,0,0,1},{0,1,0,0,1},{1,0,0,0,0}};
        gameOfLife(board);
    }
}
