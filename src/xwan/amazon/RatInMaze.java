package xwan.amazon;

/**
 * Created by xwan on 1/25/17.
 */


import java.util.ArrayList;
import java.util.List;

/**
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1].
 * A rat starts from source and has to reach destination. The rat can move only in two directions: forward and down.
 In the maze matrix, 0 means the block is dead end and 1 means the block can be used in the path from source to destination.
 Note that this is a simple version of the typical Maze problem. For example, a more complex version can be that the rat can move in 4 directions and a more complex version can be with limited number of moves.

 Following is an example maze.
 Following is binary matrix representation of the above maze.

 {1, 0, 0, 0}
 {1, 1, 0, 1}
 {0, 1, 0, 0}
 {1, 1, 1, 1}

 Following is the solution matrix (output of program) for the above input matrix.

 {1, 0, 0, 0}
 {1, 1, 0, 0}
 {0, 1, 0, 0}
 {0, 1, 1, 1}
 All enteries in solution path are marked as 1.
 */
public class RatInMaze {
    public static boolean solveMaze(int[][] maze) {
        int n = maze.length;
        int[][] resMaze = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        boolean exist = mazeHelper(maze, 0, 0, n, resMaze, visited);
        if (!exist) {
            System.out.println("Solution does not exist");
            return false;
        }

        printMaze(resMaze);
        return true;
    }

    private static boolean mazeHelper(int[][] maze, int x, int y, int n, int[][] resMaze, boolean[][] visited) {
        if (x == n - 1 && y == n - 1 && isSafe(maze, x, y)) {
            resMaze[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y) && !visited[x][y]) {
            resMaze[x][y] = 1;
            visited[x][y] = true;
            if (mazeHelper(maze, x - 1, y, n, resMaze, visited) ||
                    mazeHelper(maze, x, y + 1, n, resMaze, visited) ||
                    mazeHelper(maze, x + 1, y, n, resMaze, visited) ||
                    mazeHelper(maze, x, y - 1, n, resMaze, visited)) {
                return true;
            }
            resMaze[x][y] = 0;
            return false;
        }
        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < maze.length &&
                y >= 0 && y < maze[0].length &&
                maze[x][y] == 1);
    }

    private static void printMaze(int[][] maze) {
        int n = maze.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 1, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 1},
                {1, 1, 1, 0}};
        System.out.println(solveMaze(maze));
    }
}
