package xwan.leetcode.data_structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xwan on 1/4/17.
 */
public class SortCharactersByFrequency451 {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        ArrayList<Character>[] buckets = (ArrayList<Character>[]) new ArrayList[max + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int num = entry.getValue();
            if (buckets[num] == null) {
                buckets[num] = new ArrayList<Character>();
            }
            buckets[num].add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = max; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }

            for (char ch : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
