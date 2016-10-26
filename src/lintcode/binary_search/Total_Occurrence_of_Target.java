package lintcode.binary_search;

/**
 * Created by bosun on 10/25/16.
 */
public class Total_Occurrence_of_Target {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int low = 0;
        int high = A.length - 1;
        int left = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if(A[mid] == target) {
                left = mid;
                high = mid - 1;
            } else if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (left == -1) return 0;
        if (left == A.length - 1) return 1;
        int right = -1;
        low = left + 1;
        high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if(A[mid] == target) {
                right = mid;
                low = mid + 1;
            } else if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (right == -1) {
            return 1;
        }
        return right - left + 1;
    }
    public static void main(String[] args) {
        System.out.println(new Total_Occurrence_of_Target().totalOccurrence(new int[]{1,3,3,4,5},3));
    }
}
