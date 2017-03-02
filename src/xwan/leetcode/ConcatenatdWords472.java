package xwan.leetcode;

/**
 * Created by xwan on 2/24/17.
 */

import java.util.*;

/**
 * 472. Concatenated Words
 *
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.

 A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

 Example:
 Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

 Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

 Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 Note:
 The number of elements of the given array will not exceed 10,000
 The length sum of elements in the given array will not exceed 600,000.
 All the input string will only include lower case letters.
 The returned elements order does not matter.
 */
public class ConcatenatdWords472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (str1, str2) -> str1.length() - str2.length());

        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>();

        for (String word : words) {
            validWords(word, dict, res);
            dict.add(word);
        }

        return res;
    }
    private void validWords(String word, Set<String> dict, List<String> res) {
        if (dict.isEmpty()) return;

        int count = 0;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    count++;
                    break;
                }
            }
        }
        if (count > 1 && dp[word.length()]) {
            res.add(word);
        }
    }
}
