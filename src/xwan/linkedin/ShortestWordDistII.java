package xwan.linkedin;

/**
 * Created by xwan on 2/14/17.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 244. Shortest Word Distance II
 *
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters.
 * How would you optimize it?

 Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 */
public class ShortestWordDistII {
    private Map<String, List<Integer>> map;
    public ShortestWordDistII(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            List<Integer> tmp = map.get(word);
            tmp.add(i);
            map.put(word, tmp);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indices1 = map.get(word1);
        List<Integer> indices2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < indices1.size() && j < indices2.size()) {
            int currIdx1 = indices1.get(i);
            int currIdx2 = indices2.get(j);
            min = Math.min(min, Math.abs(currIdx1 - currIdx2));
            if (currIdx1 < currIdx2) {
                i++;
            } else {
               j++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistII wordshort = new ShortestWordDistII(words);
        System.out.println(wordshort.shortest("coding", "practice"));
        System.out.println(wordshort.shortest("makes", "coding"));
    }
}
