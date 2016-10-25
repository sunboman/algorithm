package lintcode.binary_search;

/**
 * Created by sunbo_000 on 10/24/2016.
 */

/*
    http://www.lintcode.com/en/problem/wood-cut/
    Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal
    or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given
    L & k, return the maximum length of the small pieces.
 */

public class Wood_Cut {
    public int woodCut(int[] L, int k) {
        // write your code here

        int result = 0;

        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long count = 0;
            for (int i = 0; i < L.length; i++) {
                count += L[i] / mid;
            }
            if (count >= k) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Wood_Cut().woodCut(new int[]{

        }, 2500));
    }
}
