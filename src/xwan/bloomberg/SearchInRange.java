package xwan.bloomberg;

/**
 * Created by xwan on 1/17/17.
 */
public class SearchInRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (nums[lo] != target) {
            return res;
        }
        res[0] = lo;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        res[1] = hi;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,2,8,8,8,8,8,9};
        searchRange(nums, 2);
    }
}
