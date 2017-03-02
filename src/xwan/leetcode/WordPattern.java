package xwan.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xwan on 3/1/17.
 */

/**
 * 290. Word Pattern
 *
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        str.trim();
        String[] strList = str.split(" ");
        if (pattern.length() != strList.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            if (!map.containsKey(key)) {
                if (map.containsValue(strList[i])) return false;
                map.put(key, strList[i]);
            } else {
                if (!map.get(key).equals(strList[i])) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        wordPattern("abba", "dog cat cat dog");
    }
}
