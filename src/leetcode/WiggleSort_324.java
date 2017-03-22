package leetcode;

/**
 * Created by bosun on 3/22/17.
 */
public class WiggleSort_324 {
  public void wiggleSort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }
    int n = nums.length;
    int mid = findKthLargest(nums, (n + 1) / 2, 0, n - 1);
    int idx = 0, left = 0, right = n - 1;
    while (idx <= right) {
      if (nums[newIndex(idx, n)] > mid) {
        swapII(nums, newIndex(idx++, n), newIndex(left++, n));
      } else if (nums[newIndex(idx, n)] < mid) {
        swapII(nums, newIndex(idx, n), newIndex(right--, n));
      } else {
        idx++;
      }
    }
  }

  private void swapII(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private int newIndex(int i, int n) {
    return (2 * i + 1) % (n | 1);
  }

  private int findKthLargest(int[] nums, int k, int left, int right) {
    if (left == right) {
      return nums[left];
    }
    int index = partitionII(nums, left, right);
    if (index + 1 == k) {
      return nums[index];
    } else if (index + 1 > k) {
      return findKthLargest(nums, k, left, index - 1);
    } else {
      return findKthLargest(nums, k, index + 1, right);
    }
  }

  private int partitionII(int[] nums, int left, int right) {
    int pivot = nums[left];
    while (left < right) {
      while (left < right && nums[right] >= pivot) {
        right--;
      }
      nums[left] = nums[right];
      while (left < right && nums[left] <= pivot) {
        left++;
      }
      nums[right] = nums[left];
    }
    nums[left] = pivot;
    return left;
  }
}
