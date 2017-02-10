package xwan.audible;

/**
 * Created by xwan on 2/9/17.
 */

/**
 * find a missing number in a sorted array
 */
public class FindMissingNumber {
    public static int findMissing(int[] nums) {
        int lo = 0;
        int hi = nums.length;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid < nums[mid]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (nums[lo] == lo) {
            return hi;
        } else {
            return lo;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(findMissing(nums));
    }
}
