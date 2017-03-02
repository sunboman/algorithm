package xwan.lintcode;

/**
 * Created by xwan on 2/22/17.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route.
 Return -1 if knight can not reached.

 Notice

 source and destination must be empty.
 Knight can not enter the barrier.

 Have you met this question in a real interview? Yes
 Clarification
 If the knight is at (x, y), he can get to the following positions in one step:

 (x + 1, y + 2)
 (x + 1, y - 2)
 (x - 1, y + 2)
 (x - 1, y - 2)
 (x + 2, y + 1)
 (x + 2, y - 1)
 (x - 2, y + 1)
 (x - 2, y - 1)
 Example
 [[0,0,0],
 [0,0,0],
 [0,0,0]]
 source = [2, 0] destination = [2, 2] return 2

 [[0,1,0],
 [0,0,0],
 [0,0,0]]
 source = [2, 0] destination = [2, 2] return 6

 [[0,1,0],
 [0,0,1],
 [0,0,0]]
 source = [2, 0] destination = [2, 2] return -1
 */
public class KnightShortestPath {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private final static int[][] dirs = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point curr = queue.poll();
                if (curr.x == destination.x && curr.y == destination.y) return steps;

                for (int i = 0; i < 8; i++) {
                    int nextX = curr.x + dirs[i][0];
                    int nextY = curr.y + dirs[i][1];
                    if (!isValid(nextX, nextY, n, m, grid)) continue;

                    queue.offer(new Point(nextX, nextY));
                    grid[nextX][nextY] = true; // mark visited
                }
            }
            steps++;
        }
        return -1;
    }

    private boolean isValid(int x, int y, int n, int m, boolean[][] grid) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y]) return false;
        return true;
    }

    public static void main(String[] args) {
        boolean[][] grid = {{false, false, false},{false, false, false},{false, false, false}};
        KnightShortestPath ksp = new KnightShortestPath();
        ksp.shortestPath(grid, ksp.new Point(2,0), ksp.new Point(2,2));
    }
}
