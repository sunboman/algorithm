package xwan.leetcode.binary_search_divide_conquer;

/**
 * Created by xwan on 12/27/16.
 */
public class KthLargestElement215 {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }
    private static int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        if (left == k) {
            return nums[left];
        } else if (left > k) {
            return quickSelect(nums, start, left - 1, k);
        } else {
            return quickSelect(nums, left + 1, end, k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }
}
