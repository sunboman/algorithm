package xwan.leetcode.array_numbers_string;

/**
 * Created by xwan on 12/27/16.
 */
public class MergeSortedArray88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,4,6,7,9};
        int[] num2 = {2,3,8,12};
        merge(num1, 5, num2, 4);
    }
}
