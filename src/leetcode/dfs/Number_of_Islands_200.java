package leetcode.dfs;

/**
 * Created by sunbo_000 on 10/17/2016.
 */
public class Number_of_Islands_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        char mark = 'a';
        int length = grid[0].length;
        int height = grid.length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] != '1') continue;
                dfs(i, j, grid, ++mark, length, height);
            }
        }
        return mark - 'a';
    }

    private void dfs(int row, int col, char[][] grid, char mark, int length, int height) {
        if (row < 0 || row >= height || col < 0 || col >= length) return;
        if (grid[row][col] == '1') {
            grid[row][col] = mark;
            dfs(row + 1, col, grid, mark, length, height);
            dfs(row - 1, col, grid, mark, length, height);
            dfs(row, col + 1, grid, mark, length, height);
            dfs(row, col - 1, grid, mark, length, height);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','1'}
        };

      /*  char[][] grid = {
                {'1', '0'}
        };
*/
        Number_of_Islands_200 solution = new Number_of_Islands_200();
        System.out.println(solution.numIslands(grid));
    }
}
