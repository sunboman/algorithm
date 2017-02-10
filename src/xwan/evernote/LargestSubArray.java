package xwan.evernote;

/**
 * Created by xwan on 2/10/17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Largest subarray with equal number of 0s and 1s
     Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s. Expected time complexity is O(n).

     Examples:

     Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
     Output: 1 to 6 (Starting and Ending indexes of output subarray)

     Input: arr[] = {1, 1, 1, 1}
     Output: No such subarray

     Input: arr[] = {0, 0, 1, 1, 0}
     Output: 0 to 3 Or 1 to 4
 */
public class LargestSubArray {
    public static int[] findSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int tmp = 0;
        int startIdx = -1;
        int maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tmp++;
            } else {
                tmp--;
            }
            if (map.containsKey(tmp)) {
                if (i - map.get(tmp) > maxLen) {
                    maxLen = i - map.get(tmp);
                    startIdx = map.get(tmp) + 1;
                }
            } else {
                map.put(tmp, i);
            }
        }
        if (startIdx == -1) {
            System.out.println("No such subarray");
            return new int[0];
        }

        int[] res = new int[2];
        res[0] = startIdx;
        res[1] = startIdx + maxLen - 1;
        System.out.println(res[0] + ", " + res[1]);
        return res;
    }


    /**
     * given a string only include '*' and '#', find a largest subarray include equally '*' and '#'
     *
     * example:
     *
     * s = "#*###********"
     * return "#*###***"
     */
    public static String longestStr(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int startIdx = -1;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                count++;
            } else if (s.charAt(i) == '#') {
                count--;
            }
            if (map.containsKey(count)) {
                if (i - map.get(count) > maxLen) {
                    maxLen = i - map.get(count);
                    startIdx = map.get(count) + 1;
                }
            } else {
                map.put(count, i);
            }
        }
        if (startIdx == -1) {
            System.out.println("No such subarray");
            return "";
        }
        System.out.println(s.substring(startIdx, startIdx + maxLen));
        return s.substring(startIdx, startIdx + maxLen);
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1, 0, 0};
//        findSubArray(nums);

        longestStr("#######");

    }
}
