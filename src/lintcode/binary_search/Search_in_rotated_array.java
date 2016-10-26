package lintcode.binary_search;

/**
 * Created by bosun on 10/25/16.
 */
public class Search_in_rotated_array {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] >= A[low]) {
                if (A[low] <= target && target < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Search_in_rotated_array().search(new int[]{0,1,2,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1},-9));
    }
}
