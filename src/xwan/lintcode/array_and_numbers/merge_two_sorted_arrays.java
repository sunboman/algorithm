package xwan.lintcode.array_and_numbers;


/**
 * Created by xwan on 11/28/16.
 */
public class merge_two_sorted_arrays {
    public static int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int n = A.length;
        int m = B.length;
        int[] res = new int[n + m];

        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < n && j < m) {
            if (A[i] < B[j]) {
                res[idx++] = A[i++];
            } else {
                res[idx++] = B[j++];
            }
        }

        while (i < n) {
            res[idx++] = A[i++];
        }

        while (j < m) {
            res[idx++] = B[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] aa = new int[]{1,2,4,7};
        int[] bb = new int[]{2,3,5,6,9};

        System.out.println(mergeSortedArray(aa, bb));

    }
}
