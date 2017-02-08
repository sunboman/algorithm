package xwan.audible;

/**
 * Created by xwan on 2/3/17.
 */
public class FindValleyElement {
    public static int findValley(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 2;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) {
                lo = mid;
            } else if (nums[mid] > nums[mid - 1]) {
                hi = mid;
            } else {
                hi = mid;
            }
        }
        if (nums[lo] < nums[hi]) {
            return lo;
        } else {
            return hi;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,6,3,4,8,7};
        System.out.println(findValley(nums));
    }
}
