package lintcode.binary_search;

/**
 * Created by bosun on 10/25/16.
 */

/*
    http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/
    Given a big sorted array with positive integers sorted by ascending order. The array is so big so that you can not
    get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k)
    (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k),
    where k is the first index of the target number.

    Return -1, if the number doesn't exist in the array.
 */
public class Search_in_a_big_sorted_array {
    /**
     * Definition of ArrayReader:
     */
    static class ArrayReader {
        // get the number at index, return -1 if index is less than zero.
        public static int get(int index) {
            return -1;
        }
    }

    public class Solution {
        /**
         * @param reader: An instance of ArrayReader.
         * @param target: An integer
         * @return : An integer which is the index of the target number
         */
        public int searchBigSortedArray(ArrayReader reader, int target) {
            // write your code here
            int low = 0;
            int high = 1;
            int result = -1;
            while (reader.get(high) != 2147483647) {
                if (reader.get(high) > target) {
                    break;
                } else if (reader.get(high) == target) {
                    result = high;
                    high = high - 1;
                    break;
                } else {
                    high = high << 1;
                }
            }

            while (low <= high) {
                int mid = (low + high) >> 1;
                if (reader.get(mid) == target) {
                    result = mid;
                    high = mid - 1;
                } else if (reader.get(mid) > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return result;
        }
    }
}
