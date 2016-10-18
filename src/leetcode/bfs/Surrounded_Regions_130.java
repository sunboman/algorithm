package leetcode.bfs;

import java.util.LinkedList;

/**
 * Created by sunbo_000 on 10/4/2016.
 */
public class Surrounded_Regions_130 {
    public void solve(char[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int width = board.length;
        int length = board[0].length;

        for (int i = 0; i < length; i++) {
//            if (board[0][i] == 'o') dfs(0, i, board, length, width);
//            if (board[length - 1][i] == 'o') dfs(length - 1, i, board, length, width);
            if (board[0][i] == 'o') bfs(0, i, board);
            if (board[width - 1][i] == 'o') bfs(width - 1, i, board);
        }

        for (int i = 0; i < width; i++) {
//            if (board[i][0] == 'x') dfs(i, 0, board, length, width);
//            if (board[i][width - 1] == 'x') dfs(i, width - 1, board, length, width);
            if (board[i][0] == 'o') bfs(i, 0, board);
            if (board[i][length - 1] == 'o') bfs(i, length - 1, board);
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 'o') board[i][j] = 'x';
                if (board[i][j] == 'y') board[i][j] = 'o';
            }
        }

    }

    void bfs(int x, int y, char[][] board) {

        int width = board.length;
        int length = board[0].length;

        board[x][y] = 'y';
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(x * width + y);
        while (!queue.isEmpty()) {
            int t = queue.poll();
            int i = t / width;
            int j = t % width;

            if ((i + 1 < length) && (board[i + 1][j] == 'o')) {
                queue.offer((i + 1) * width + j);
                board[i + 1][j] = 'y';
            }

            if ((i - 1 >= 0) && (board[i - 1][j] == 'o')) {
                queue.offer((i - 1) * width + j);
                board[i - 1][j] = 'y';
            }

            if ((j + 1 < width) && (board[i][j + 1] == 'o')) {
                queue.offer(i * width + j + 1);
                board[i][j + 1] = 'y';
            }

            if ((j - 1 >= 0) && (board[i][j - 1] == 'o')) {
                queue.offer(i * width + j - 1);
                board[i][j - 1] = 'y';
            }

        }
    }

    void dfs(int x, int y, char[][] board, int length, int width) {

        if (!(x >= 0 && x < length && y >= 0 && y < width)) return;
        if (board[x][y] == 'o') board[x][y] = 'y';

        dfs(x + 1, y, board, length, width);
        dfs(x - 1, y, board, length, width);
        dfs(x, y + 1, board, length, width);
        dfs(x, y - 1, board, length, width);

    }

    public static void main(String[] args) {
        Surrounded_Regions_130 solution = new Surrounded_Regions_130();
        char[][] board = new char[][]{{'x', 'x', 'x', 'x'}, {'x', 'o', 'o', 'x'}, {'x', 'x', 'o', 'x'}, {'x', 'o', 'x', 'x'}, {'x', 'o', 'x', 'x'},{'x', 'x', 'x', 'x'}};
//        char[][] board = new char[][]{["XOXOXO","OXOXOX","XOXOXO","OXOXOX"]};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        solution.solve(board);
        System.out.println("--------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
