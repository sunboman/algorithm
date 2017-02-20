package xwan.ood.design.delayscheduler;

import java.util.Timer;

/**
 * Created by xwan on 2/15/17.
 */
public class Test {
    int val; // 1: black, 2: white, 0: empty.

    // dfs subroutine to explore same color tokens.
    boolean findEmptyNeighbor(int[][] board, int i, int j) {
        // didn't find empty grid if out of board
        if (i < 0 || i > 18 || j < 0 || j > 18
                || board[i][j] == Integer.MAX_VALUE || board[i][j] == -val) return false; // or visited same color token or opponent token
        if (board[i][j] == 0) return true;
        board[i][j] = Integer.MAX_VALUE; // set as "visited"
        // explore 4 neighboring grids
        return findEmptyNeighbor(board, i - 1, j) ||
                findEmptyNeighbor(board, i + 1, j) ||
                findEmptyNeighbor(board, i, j - 1) ||
                findEmptyNeighbor(board, i, j + 1);
    }
    boolean isAlive(int[][] board, int i, int j) {
        // validate given location (i, j)
        if (i < 0 || i > 18 || j < 0 || j > 18 || board[i][j] == 0) return false;
        val = board[i][j];
        return findEmptyNeighbor(board, i, j);
    }
    public static void main(String[] args) {

    }
}
