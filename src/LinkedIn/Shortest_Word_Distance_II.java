package LinkedIn;

import java.util.*;

/**
 * Created by sunbo on 12/29/2016.
 */
/*
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method
will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and
 word2 and return the shortest distance between these two words in the list.

For example,

Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding”, word2 = "practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.
 */
public class Shortest_Word_Distance_II {
    private static class WordDistance {
        Map<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                List<Integer> list = new ArrayList<>();
                if (map.containsKey(word)) {
                    list = map.get(word);
                }
                list.add(i);
                map.put(word, list);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            if (list1 == null || list2 == null || list1.size() == 0 || list2.size() == 0) {
                return Integer.MAX_VALUE;
            }
            Collections.sort(list1);
            Collections.sort(list2);
            int res = Integer.MAX_VALUE;
            int i = 0;
            int j = 0;
            while (i < list1.size() && j < list2.size()) {
                res = Math.min(res, Math.abs(list1.get(i) - list2.get(j)));
                if (list1.get(i) > list2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }

        public int shortest(String word1, String word2, String word3) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            List<Integer> list3 = map.get(word3);
            int i = 0;
            int j = 0;
            int k = 0;
            int min = Integer.MAX_VALUE;
            while (i < list1.size() && j < list2.size() && k < list3.size()) {
                int left, right;
                int a = list1.get(i);
                int b = list2.get(j);
                int c = list3.get(k);
                left = Math.min(a, Math.min(b, c));
                right = Math.max(a, Math.max(b, c));
                min = Math.min(min, right - left + 1);
                if (a < b && a < c) {
                    i++;
                } else if (b < c && b < a) {
                    j++;
                } else {
                    k++;
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{
                "a", "b", "a", "b", "b", "b", "b", "c", "b", "b", "a", "c"
        };
        WordDistance wordDistance = new WordDistance(words);
        int res = wordDistance.shortest("a", "b", "c");
    }
}
