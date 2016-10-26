package lintcode.binary_search;

/**
 * Created by bosun on 10/25/16.
 */

/*
    http://www.lintcode.com/en/problem/k-closest-numbers-in-sorted-array/
    Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest
    numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted
    in ascending order by number if the difference is same.
 */
public class K_Closest_Numbers_In_Sorted_Array {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        int[] result = new int[k];
        if (A == null || A.length == 0 || k == 0) {
            return result;
        }


        if (target <= A[0]) {
            for (int i = 0; i < k; i++) {
                result[i] = A[i];
            }
            return result;
        }

        if (target >= A[A.length - 1]) {
            int j = 0;
            for (int i = A.length - 1; i > A.length - 1 - k; i--) {
                result[j++] = A[i];
            }
            return result;
        }

        int low = 0;
        int high = A.length - 1;
        while (low + 1 < high) {
            int mid = (low + high) >>> 1;
            if (A[mid] == target) {
                high = mid;
                break;
            } else if (A[mid] < target) {
                low = mid;
            } else if (A[mid] > target){
                high = mid;
            }
        }

        int targetIndex = -1;
        if (target == A[high]) {
            targetIndex = high;
        } else if (A[high] - target < target - A[high - 1]) {
            targetIndex = high;
        } else {
            targetIndex = low;
        }
        result[0] = A[targetIndex];
        int left = targetIndex - 1;
        int right = targetIndex + 1;
        for (int i = 1; i < k; i++) {
            if (left < 0) {
                result[i] = A[right++];
            } else if (right >= A.length) {
                result[i] = A[left--];
            } else {
                if (target - A[left] <= A[right] - target) {
                    result[i] = A[left--];
                } else {
                    result[i] = A[right++];
                }
            }
        }
        return result;
    }
}
