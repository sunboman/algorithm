package xwan.leetcode;

/**
 * Created by xwan on 2/26/17.
 */

import java.util.*;

/**
 * 336. Palindrome Pairs
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]
 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
public class PalindromPairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        Set<List<Integer>> temp = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                if (isPalindrom(left)) {
                    List<Integer> pair = getPair(map, right, i);
                    if (pair != null && pair.size() > 0) {
                        Collections.reverse(pair);
                        temp.add(pair);
                    }
                }
                if (isPalindrom(right)) {
                    List<Integer> pair = getPair(map, left, i);
                    if (pair != null && pair.size() > 0) temp.add(pair);
                }
            }
        }
        if (temp.size() > 0) res = new ArrayList<>(temp);
        return res;
    }

    private List<Integer> getPair(Map<String, Integer> map, String s, int i) {
        List<Integer> res = new ArrayList<>();
        String revS = new StringBuilder(s).reverse().toString();
        if (map.containsKey(revS) && map.get(revS) != i) {
            res.add(i);
            res.add(map.get(revS));
        }
        return res;
    }

    private boolean isPalindrom(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
}
