package leetcode;

import java.util.*;

/**
 * Created by bosun on 4/5/17.
 */
public class Friedns_Cycle_547 {
  public int findCircleNum(int[][] M) {
    if (M == null || M.length <= 1) {
      return 0;
    }
    Set<Integer> visited = new HashSet<>();
    int n = M.length, res = 0;
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (visited.contains(i)) {
        continue;
      }
      res++;
      queue.offer(i);
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int j = 0; j < size; j++) {
          int p = queue.poll();
          visited.add(p);
          for (int k = 0; k < n; k++) {
            if (k == p) {
              continue;
            }
            if (M[p][k] == 1 && !visited.contains(k)) {
              queue.offer(k);
            }
          }
        }
      }
      queue.clear();
    }
    return res;
  }
  public int findCircleNumII(int[][] M) {
    if (M == null || M.length == 0) {
      return 0;
    }
    int n = M.length, res = 0;
    for (int i = 0; i < n; i++) {
      if (M[i][i] == 1) {
        res++;
        bfs(i, M);
      }
    }
    return res;
  }
  private void bfs(int i, int[][] M) {
    LinkedList<Integer> queue = new LinkedList<>();
    int n = M.length;
    queue.offer(i);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        int p = queue.poll();
        M[p][p] = 2;
        for (int k = 0; k < n; k++) {
          if (M[p][k] == 1 && M[k][k] == 1) {
            queue.add(k);
          }
        }
      }
    }
  }
  public static void main(String[] args) {
    int res = new Friedns_Cycle_547().findCircleNum(new int[][]{
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
    });
  }
}
