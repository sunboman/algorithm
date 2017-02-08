package xwan.bloomberg;

/**
 * Created by xwan on 1/30/17.
 */

/**
 * Find the maximum repeating number in O(n) time and O(1) extra space
 *
 Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= n.
 Find the maximum repeating number in this array. For example, let k be 10 the given array be arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3},
 the maximum repeating number would be 2. Expected time complexity is O(n) and extra space allowed is O(1). Modifications to array are allowed.

 *
 *
 * Example:
 * arr[] = {2, 3, 3, 5, 3, 4, 1, 7, 2,3,3}, k = 8, n = 11
 */
public class FindMaxRepeating {
    public static int maxRepeating(int[] nums, int k, int n) {
        for (int i = 0; i < n; i++) {
            nums[nums[i] % k] += k;
        }
        int max = nums[0];
        int sec = nums[0];
        int maxRes = 0;
        int secRec = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxRes = i;
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] < max && nums[i] > sec) {
                sec = nums[i];
                secRec = i;
            }
        }

        System.out.println(maxRes + ", " + secRec);
        return maxRes;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 3};
        maxRepeating(arr, 4 , arr.length);
    }
}
