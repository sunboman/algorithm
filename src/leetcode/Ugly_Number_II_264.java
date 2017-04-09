package leetcode;

import java.util.*;

/**
 * Created by sunbo on 3/11/2017.
 */
public class Ugly_Number_II_264 {
  public int nthUglyNumber(int n) {
    PriorityQueue<Long> heap = new PriorityQueue<>();
    Set<Long> set = new HashSet<>();
    set.add((long) 1);
    heap.offer((long) 1);
    int[] primes = new int[]{2, 3, 5};
    for (int i = 1; i <= n; i++) {
      Long num = heap.poll();
      if (i == n) {
        return num.intValue();
      }
      for (int j = 0; j < 3; j++) {
        if (set.add(primes[j] * num)) {
          heap.offer(primes[j] * num);
        }
      }
    }
    return -1;
  }

  public int nthUglyNumberII(int n) {
    int two = 0, three = 0, five = 0;
    List<Integer> list = new ArrayList<>();
    list.add(1);
    while (list.size() < n) {
      int a = list.get(two) * 2;
      int b = list.get(three) * 3;
      int c = list.get(five) * 5;
      int min = Math.min(a, Math.min(b, c));
      list.add(min);
      if (a == min) two++;
      if (b == min) three++;
      if (c == min) five++;
    }
    return list.get(n - 1);
  }
}
