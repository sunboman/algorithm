package Evernote;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunbo on 2/9/2017.
 */
/*
Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s. Expected time complexity is O(n).

Examples:

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6 (Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4
 */
public class Largest_SubArray_With_Equal_One_Zeros {
    public int[] findSubArray(int arr[]) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int temp = 0;
        int len = 0;
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                temp++;
            } else {
                temp--;
            }
            if (!map.containsKey(temp)) {
                map.put(temp, i);
            } else {
                if (i - map.get(temp) > len) {
                    len = i - map.get(temp);
                    start = map.get(temp) + 1;
                }
            }
        }
        int[] res = new int[len];
        System.arraycopy(arr, start, res, 0, len);
        return res;
    }

    public static void main(String[] args) {
        new Largest_SubArray_With_Equal_One_Zeros().findSubArray(new int[]{0, 0, 1, 1, 0});
    }
}
