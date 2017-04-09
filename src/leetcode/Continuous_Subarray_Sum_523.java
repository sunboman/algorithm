package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunbo on 3/11/2017.
 */
public class Continuous_Subarray_Sum_523 {
  public static boolean checkSubarraySum(int[] nums, int k) {
    if (nums == null || nums.length < 2) {
      return false;
    }
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (k != 0) sum %= k;
      if (map.containsKey(sum)) {
        if (i - map.get(sum) > 1)
          return true;
      } else {
        map.put(sum, i);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    checkSubarraySum(new int[]{23, 2, 5, 6, 7}, 6);
  }
}
