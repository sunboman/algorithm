package leetcode.String_Array;

/**
 * Created by sunbo_000 on 10/20/2016.
 */

/*
    https://leetcode.com/problems/median-of-two-sorted-arrays/
    There are two sorted arrays nums1 and nums2 of size m and n respectively.

    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

    Example 1:
    nums1 = [1, 3]
    nums2 = [2]

    The median is 2.0
    Example 2:
    nums1 = [1, 2]
    nums2 = [3, 4]

    The median is (2 + 3)/2 = 2.5

 */
public class Median_of_Two_Sorted_Arrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1_len = nums1.length;
        int nums2_len = nums2.length;
        if ((nums1_len + nums2_len) % 2 == 0) {
            double res1 = (double) findMedian(nums1, 0, nums1_len - 1, nums2, 0, nums2_len - 1, (nums1_len + nums2_len) / 2);
            double res2 = (double) findMedian(nums1, 0, nums1_len - 1, nums2, 0, nums2_len - 1, (nums1_len + nums2_len) / 2 + 1);
            return (res1 + res2) / 2;
        } else
            return (double) findMedian(nums1, 0, nums1_len - 1, nums2, 0, nums2_len - 1, (nums1_len + nums2_len + 1) / 2);
    }

    private int findMedian(int[] A, int startA, int endA, int[] B, int startB, int endB, int k) {
        int aLen = endA - startA;
        int bLen = endB - startB;
        if (aLen <= 0) return B[startB + k];
        if (bLen <= 0) return A[startA + k];
        if (k == 1) return A[startA] < B[startB] ? A[startA] : B[startB];
        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;

        if (A[midA] <= B[midB]) {
            if (aLen / 2 + bLen / 2 >= k - 1) return findMedian(A, startA, endA, B, startB, midB, k);
            else return findMedian(A, midA + 1, endA, B, startB, endB, k - aLen / 2 - 1);
        } else {
            if (aLen / 2 + bLen / 2 >= k - 1) return findMedian(A, startA, midA, B, startB, endB, k);
            else return findMedian(A, startA, endA, B, midB + 1, endB, k - bLen / 2 - 1);
        }
    }
    public double findMedianSortedArraysII(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if ((n + m) % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, (n + m) / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, (n + m) / 2) + findKth(nums1, 0, nums2, 0, (n + m) / 2 + 1)) / 2.0;
        }
    }
    private int findKth(int[] a, int a_start, int[] b, int b_start, int k) {
        if (a_start >= a.length) {
            return b[b_start + k - 1];
        }
        if (b_start >= b.length) {
            return a[a_start + k - 1];
        }
        if (k == 1) {
            return Math.min(a[a_start], b[b_start]);
        }
        int aK = a_start + k / 2 - 1 < a.length ? a[a_start + k / 2 - 1] : Integer.MAX_VALUE;
        int bK = b_start + k / 2 - 1 < b.length ? b[b_start + k / 2 - 1] : Integer.MAX_VALUE;
        if (bK < aK) {
            return findKth(a, a_start, b, b_start + k / 2, k - k / 2);
        } else {
            return findKth(a, a_start + k / 2, b, b_start, k - k / 2);
        }
    }
}
