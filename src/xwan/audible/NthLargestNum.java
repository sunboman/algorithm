package xwan.audible;

/**
 * Created by xwan on 2/3/17.
 */

/**
 * find nth largest element in an array
 */
public class NthLargestNum {
    public static int findNthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }
    private static int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int pos = partition(nums, start, end);
        if (pos == k) {
            return nums[pos];
        } else if (pos < k) {
            return quickSelect(nums, pos + 1, end, k);
        } else {
            return quickSelect(nums, start, pos - 1, k);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int pivot = nums[l];
        while (l < r) {
            while (r > l && nums[r] <= pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] >= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
    public static void main(String[] args) {
        int[] nums = {2, 5, 3, 8, 6, 1};
        System.out.println(findNthLargest(nums, 1));
    }
}
