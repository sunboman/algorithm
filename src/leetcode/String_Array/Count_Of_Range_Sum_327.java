package leetcode.String_Array;

/**
 * Created by sunbo on 2/7/2017.
 */
public class Count_Of_Range_Sum_327 {
    int lower, upper, count;

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        this.lower = lower;
        this.upper = upper;
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        mergeSort(sums, 0, n);
        return count;
    }

    private void mergeSort(long[] sums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >>> 1;
        mergeSort(sums, start, mid);
        mergeSort(sums, mid + 1, end);
        merge(sums, start, mid, end);
    }

    private void merge(long[] sums, int start, int mid, int end) {
        long[] temp = new long[end - start + 1];
        int j = mid + 1;
        int k = mid + 1;
        int right = mid + 1;
        int t = 0;
        for (int i = start; i <= mid; i++) {
            while (j <= end && sums[j] - sums[i] <= upper) {
                j++;
            }
            while (k <= end && sums[k] - sums[i] < lower) {
                k++;
            }
            while (right <= end && sums[right] < sums[i]) {
                temp[t++] = sums[right++];
            }
            temp[t++] = sums[i];
            count += j - k;
        }
        while (right <= end) {
            temp[t++] = sums[right++];
        }
        System.arraycopy(temp, 0, sums, start, end - start + 1);
    }

    public static void main(String[] args) {
        new Count_Of_Range_Sum_327().countRangeSum(new int[]{-2, 5, -1}, -2, 2);
    }
}
