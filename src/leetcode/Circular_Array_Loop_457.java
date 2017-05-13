package leetcode;

/**
 * Created by bosun on 5/13/17.
 */
public class Circular_Array_Loop_457 {
  public boolean circularArrayLoop(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        continue;
      }
      int slow = i, fast = i;
      do {
        if (nums[fast] * nums[i] <= 0 || nums[getNextIndex(nums, fast)] * nums[i] <= 0) {
          break;
        }
        slow = getNextIndex(nums, slow);
        fast = getNextIndex(nums, getNextIndex(nums, fast));
        if (slow == fast) {
          if (getNextIndex(nums, slow) == fast) break;
          return true;
        }
      } while (nums[fast] * nums[i] > 0 && nums[getNextIndex(nums, fast)] * nums[i] > 0);
      int step = nums[i];
      int idx = i;
      while (nums[idx] * step > 0) {
        nums[idx] = 0;
        idx = getNextIndex(nums, idx);
      }
    }
    return false;
  }

  private int getNextIndex(int[] nums, int i) {
    int next = i + nums[i], n = nums.length;
    if (next < 0) {
      next = Math.abs(next);
      next %= n;
      return n - next;
    } else {
      return next % n;
    }
  }

  public static void main(String[] args) {
    new Circular_Array_Loop_457().circularArrayLoop(new int[]{-1, 2});
  }
}
