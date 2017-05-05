package leetcode;

import java.util.*;

/**
 * Created by bosun on 5/3/17.
 */
public class Queue_Reconstruction_By_Height_406 {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> {
              if (a[0] != b[0]) {
                return b[0] - a[0];
              } else {
                return a[1] - b[1];
              }
            }
    );
    int n = people.length;
    LinkedList<int[]> list = new LinkedList<>();
    for (int[] aPeople : people) {
      list.add(aPeople[1], aPeople);
    }
    int[][] res = new int[n][2];
    list.toArray(res);
    return res;
  }
}
