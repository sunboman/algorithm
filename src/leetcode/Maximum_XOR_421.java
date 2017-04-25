package leetcode;

import java.util.*;

/**
 * Created by bosun on 4/24/17.
 */
public class Maximum_XOR_421 {
  public int findMaximumXOR(int[] nums) {
    int max = 0, mask = 0;
    for (int i = 31; i >= 0; i--) {
      mask = mask | (1 << i);
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
        set.add(num & mask);
      }
      int tmp = max | (1 << i);
      for (int prefix : set) {
        if (set.contains(tmp ^ prefix)) {
          max = tmp;
          break;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    new Maximum_XOR_421().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
  }
}
