package xwan.leetcode.array_numbers_string;

import java.util.Arrays;

/**
 * Created by xwan on 12/29/16.
 */
public class HIndex274 {
    // solution with sort first, O(lgn)
    public int hIndex_1(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

    // solution with extra space, O(n)
    public int hIndex_2(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int num : citations) {
            if (num >= n) {
                count[n]++;
            } else {
                count[num]++;
            }
        }
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
}
