package leetcode;

import java.util.*;

/**
 * Created by bosun on 10/23/16.
 */

/*
    https://leetcode.com/problems/substring-with-concatenation-of-all-words/
    You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of
    substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

    For example, given:
    s: "barfoothefoobarman"
    words: ["foo", "bar"]

    You should return the indices: [0,9].
    (order does not matter).
 */

public class Substring_with_Concatenation_of_All_Words_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;
        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            if (!dict.containsKey(word)) {
                dict.put(word, 1);
            } else {
                dict.put(word, dict.get(word) + 1);
            }
        }

        int wLen = words[0].length();
        for (int i = 0; i < wLen; i++) {
            Map<String, Integer> found = new HashMap<>();
            int start = i;
            int count = 0;
            for (int j = i; j <= s.length() - wLen; j = j + wLen) {
                String str = s.substring(j, j + wLen);
                if (dict.containsKey(str)) {
                    if (!found.containsKey(str)) {
                        found.put(str, 1);
                    } else {
                        found.put(str, found.get(str) + 1);
                    }
                    count++;
                    while (found.get(str) > dict.get(str)) {
                        String left = s.substring(start, start + wLen);
                        found.put(left, found.get(left) - 1);
                        count--;
                        start += wLen;
                    }
                    if (count == words.length) {
                        result.add(start);
                        String left = s.substring(start, start + wLen);
                        found.put(left, found.get(left) - 1);
                        count--;
                        start += wLen;
                    }
                } else {
                    start = j + wLen;
                    count = 0;
                    found.clear();
                }
            }
        }
        return result;

    }


    public static void main(String[] args) {
        List<Integer> result = new Substring_with_Concatenation_of_All_Words_30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        String stop = "";
    }


}
