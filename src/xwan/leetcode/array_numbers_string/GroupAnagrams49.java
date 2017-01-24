package xwan.leetcode.array_numbers_string;

import java.util.*;

/**
 * Created by xwan on 12/28/16.
 */
public class GroupAnagrams49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for (List tmp : map.values()) {
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs); // [["ate", "eat","tea"],["nat","tan"],["bat"]]
    }
}
