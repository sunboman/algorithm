package xwan.lintcode.array_and_numbers;

import java.util.Arrays;

/**
 * Created by xwan on 12/21/16.
 */
public class Wiggle_Sort_II {
    public static void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        int mid = partition(temp, 0, n - 1, n / 2);

        int[] ans = new int[n];
        // ans = Arrays.fill(mid);
        for (int i = 0; i < n; i++) {
            ans[i] = mid;
        }
        int left = 0;
        int right = 0;

        if (n % 2 == 0) {
            left = n - 2;
            right = 1;
        } else {
            left = n - 1;
            right = 1;
        }

        fillArray(ans, left, right, mid, nums);

        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }

    private static int[] fillArray(int[] arr, int left, int right, int val, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < val) {
                arr[left] = nums[i];
                left -= 2;
            } else if (nums[i] > val) {
                arr[right] = nums[i];
                right += 2;
            }
        }

        return arr;
    }

    private static int partition(int[] temp, int start, int end, int rank) {
        int pivot = temp[start];
        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && temp[right] >= pivot) {
                right--;
            }
            temp[left] = temp[right];

            while (left < right && temp[left] <= pivot) {
                left++;
            }
            temp[right] = temp[left];
        }

        temp[left] = pivot;

        if (left - start < rank) {
            return partition(temp, left + 1, end, rank - (left - start) - 1);
        } else if (left - start > rank) {
            return partition(temp, start, right - 1, rank);
        }
        return pivot;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
    }
}
