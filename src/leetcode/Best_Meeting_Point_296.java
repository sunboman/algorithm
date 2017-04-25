package leetcode;

import java.util.*;

/**
 * Created by bosun on 4/25/17.
 */
/*
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1,
where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance,
where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 */
public class Best_Meeting_Point_296 {
  public int solution(int[][] grid) {
    List<Integer> rows = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();
    int n = grid.length, m = grid[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          rows.add(i);
          cols.add(j);
        }
      }
    }
    int sum = 0;
    for (int row : rows) {
      sum += Math.abs(row - rows.get(rows.size() / 2));
    }
    Collections.sort(cols);
    for (int col : cols) {
      sum += Math.abs(col - cols.get(cols.size() / 2));
    }
    return sum;
  }
}
