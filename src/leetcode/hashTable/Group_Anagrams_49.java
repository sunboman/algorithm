package leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunbo_000 on 10/18/2016.
 */

/*
    https://leetcode.com/problems/anagrams/

    Given an array of strings, group anagrams together.

    For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Return:

    [
      ["ate", "eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
 */

public class Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] s = new char[26];
            for (int i = 0; i < str.length(); i++) s[str.charAt(i) - 'a']++;
            String key = new String(s);
            if (!map.containsKey(key)) {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                map.put(key, anagrams);
            } else map.get(key).add(str);
        }
        ret.addAll(map.values());
        return ret;
    }

    public static void main(String[] args) {
        Group_Anagrams_49 solution = new Group_Anagrams_49();
        List<List<String>> result = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        String stop = "";
    }
}
