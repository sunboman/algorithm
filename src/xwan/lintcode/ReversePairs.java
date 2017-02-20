package xwan.lintcode;

/**
 * Created by xwan on 2/13/17.
 */

/**
 * For an array A, if i < j, and A [i] > A [j], called (A [i], A [j]) is a reverse pair.
 return total of reverse pairs in A.

 Have you met this question in a real interview? Yes
 Example
 Given A = [2, 4, 1, 3, 5] , (2, 1), (4, 1), (4, 3) are reverse pairs. return 3


 */
public class ReversePairs {
    public long reversePairs(int[] A) {
        // Write your code here
        if (A == null || A.length < 2) {
            return 0;
        }
        return mergeSort(A, 0, A.length - 1);
    }

    private long mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        long sum = 0;

        sum += mergeSort(nums, start, mid);
        sum += mergeSort(nums, mid + 1, end);
        sum += merge(nums, start, mid, end);
        return sum;
    }

    private long merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[nums.length];
        int leftIdx = start;
        int rightIdx = mid + 1;
        int idx = start;
        long sum = 0;
        while (leftIdx <= mid && rightIdx <= end) {
            if (nums[leftIdx] <= nums[rightIdx]) {
                tmp[idx++] = nums[leftIdx++];
            } else {
                tmp[idx++] = nums[rightIdx++];
                sum += mid - leftIdx + 1;
            }
        }
        while (leftIdx <= mid) {
            tmp[idx++] = nums[leftIdx++];
        }
        while (rightIdx <= end) {
            tmp[idx++] = nums[rightIdx++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = tmp[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 5};
        new ReversePairs().reversePairs(nums);
    }
}
