package lintcode.binary_search;

/**
 * Created by bosun on 10/25/16.
 */

/*
    http://www.lintcode.com/en/problem/closest-number-in-sorted-array/

    Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is
    closest to the given target.

    Return -1 if there is no element in the array.
 */

public class Closest_Number_in_a_sorted_array {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        if (target <= A[0]) {
            return 0;
        }
        if (target >= A[A.length - 1]) {
            return A.length - 1;
        }
        int index = firstIndex(A, target);

        if (target - A[index - 1] < A[index] - target) {
            return index - 1;
        }
        return index;
    }

    private int firstIndex(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(new Closest_Number_in_a_sorted_array().closestNumber(new int[]{
                1,13,14
        },2));
    }
}
