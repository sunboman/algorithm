package xwan.audible;

/**
 * Created by xwan on 2/3/17.
 */

/**
 * There is an integer array which has the following features:

     The numbers in adjacent positions are different.
     A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
     We define a position P is a peek if:

     A[P] > A[P-1] && A[P] > A[P+1]
     Find a peak element in this array. Return the index of the peak.
 *
 *  Example
     Given [1, 2, 1, 3, 4, 5, 7, 6]

     Return index 1 (which is number 2) or 6 (which is number 7)


 */


public class FindPeakElement {
    public static int findPeak(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int n = nums.length;
        int lo = 0;
        int hi = n - 2;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid - 1]) {
                hi = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (nums[lo] < nums[hi]) {
            return hi;
        } else {
            return lo;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 4, 5, 6};
        System.out.println(findPeak(nums));
    }
}
