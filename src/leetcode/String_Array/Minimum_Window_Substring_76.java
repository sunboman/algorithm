package leetcode.String_Array;

/**
 * Created by sunbo_000 on 10/19/2016.
 */

/*
    https://leetcode.com/problems/minimum-window-substring/
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    For example,
    S = "ADOBECODEBANC"
    T = "ABC"
    Minimum window is "BANC".

    Note:
    If there is no such window in S that covers all characters in T, return the empty string "".

    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Used two pointers. The right one scan to the right until
 */

public class Minimum_Window_Substring_76 {
    public String minWindow(String s, String t) {
        String res = "";
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char tc = t.charAt(i);
            if (!target.containsKey(tc)) target.put(tc, 1);
            else target.put(tc, target.get(tc) + 1);
        }

        Map<Character, Integer> countMap = new HashMap<>();
        int count = 0;
        int left = 0;
        int minLen = s.length() + 1;
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (target.containsKey(sc)) {
                if (!countMap.containsKey(sc)) {
                    countMap.put(sc, 1);
                    count++;
                } else {
                    if (countMap.get(sc) < target.get(sc)) {
                        count++;
                    }
                    countMap.put(sc, countMap.get(sc) + 1);
                }
            }

            if (count != t.length()) continue;
            char leftChar = s.charAt(left);
            while (!countMap.containsKey(leftChar) || countMap.get(leftChar) > target.get(leftChar)) {
                if (countMap.containsKey(leftChar)) {
                    countMap.put(leftChar, countMap.get(leftChar) - 1);
                }
                left++;
                leftChar = s.charAt(left);
            }

            if (i - left + 1 < minLen) {
                res = s.substring(left, i + 1);
                minLen = i - left + 1;
            }
        }
        return res;
    }
}
