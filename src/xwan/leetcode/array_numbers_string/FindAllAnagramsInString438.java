package xwan.leetcode.array_numbers_string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwan on 1/5/17.
 */
public class FindAllAnagramsInString438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        int[] hash = new int[256];
        for (char ch : p.toCharArray()) {
            hash[ch]++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) {
                count--;
            }
            if (count == 0) {
                res.add(left);
            }
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findAnagrams("cbadedacd", "abc");
    }
}
