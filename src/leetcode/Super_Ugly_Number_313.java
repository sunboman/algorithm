package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunbo on 3/11/2017.
 */
public class Super_Ugly_Number_313 {
  public static int nthSuperUglyNumber(int n, int[] primes) {
    int m = primes.length;
    int[] idx = new int[m];
    List<Integer> list = new ArrayList<>();
    list.add(1);
    while (list.size() < n) {
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < m; i++) {
        min = Math.min(min, list.get(idx[i]) * primes[i]);
      }
      list.add(min);
      for (int i = 0; i < m; i++) {
        if (list.get(idx[i]) * primes[i] <= min) idx[i]++;
      }
    }
    return list.get(n - 1);
  }

  public static void main(String[] args) {

    int res = nthSuperUglyNumber(7, new int[]{2, 7, 13, 19});
  }
}
