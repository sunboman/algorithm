package lintcode.binary_search;

/**
 * Created by bosun on 10/25/16.
 */

/*
    http://www.lintcode.com/en/problem/search-for-a-range/
    Given a sorted array of n integers, find the starting and ending position of a given target value.

    If the target is not found in the array, return [-1, -1].
 */
public class Search_for_a_Range {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return new int[]{-1,-1};
        }

        int low = 0;
        int high = A.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (A[mid] == target) {
                first = mid;
                high = mid -1;
            } else if (A[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        if (first == -1) {
            return new int[]{-1,-1};
        }

        int second = -1;
        low = first;
        high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (A[mid] == target) {
                second = mid;
                low = mid + 1;
            } else if (A[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        if (second == -1) {
            return new int[]{first,first};
        }
        return new int[]{first, second};
    }

    public static void main(String[] args) {
        System.out.println(new Search_for_a_Range().searchRange(new int[]{5, 7, 7, 8, 8, 10},8));
    }
}
