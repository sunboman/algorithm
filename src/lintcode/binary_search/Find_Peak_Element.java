package lintcode.binary_search;

/**
 * Created by sunbo_000 on 10/24/2016.
 */

/*
    http://www.lintcode.com/en/problem/find-peak-element/
    There is an integer array which has the following features:

    The numbers in adjacent positions are different.
    A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
    We define a position P is a peek if:

    A[P] > A[P-1] && A[P] > A[P+1]
    Find a peak element in this array. Return the index of the peak.
 */
public class Find_Peak_Element {
    public int findPeak(int[] A) {
        // write your code here
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }

            if (A[mid] <= A[low]) {
                if (mid != low) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else if (A[mid] <= A[high]) {
                low = mid + 1;
            } else if (A[mid] > A[low] && A[mid] > A[high]) {
                if (A[mid + 1] > A[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(new Find_Peak_Element().findPeak(new int[]{1, 2, 1, 3, 4, 5, 7, 6}));
    }
}
