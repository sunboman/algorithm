package leetcode;

import java.util.Arrays;

/**
 * Created by bosun on 4/28/17.
 */
public class Russian_Doll_Envelop_354 {
  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (a, b) -> {
      if (a[0] != b[0]) return a[0] - b[0];
      else return b[1] - a[1];
    });
    int[] temp = new int[envelopes.length];
    int res = 0;
    for (int[] e : envelopes) {
      int idx = Arrays.binarySearch(temp, 0, res, e[1]);
      if (idx < 0) idx = -(idx + 1);
      temp[idx] = e[1];
      if (idx == res) res++;
    }
    return res;
  }
}
