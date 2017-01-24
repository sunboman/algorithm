package xwan.lintcode.data_structure;

import java.util.*;

/**
 * Created by xwan on 11/30/16.
 */
public class top_k_frequent_words_471 {
    class ResultType {
        String word;
        int val;

        public ResultType(String word, int val) {
            this.word = word;
            this.val = val;
        }
    }

    class MyComparator implements Comparator<ResultType> {
        public int compare(ResultType r1, ResultType r2) {
            if (r1.val == r2.val) {
                return r2.word.compareTo(r1.word);
            }
            return r1.val - r2.val;
        }
    }

    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        String[] results = new String[k];

        if (words == null || k == 0) {
            return results;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = words.length - 1; i >= 0; i--)  {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }

        PriorityQueue<ResultType> pq = new PriorityQueue<>(k, new MyComparator());
        Set<String> hash = map.keySet();
        Iterator it = hash.iterator();

        while (it.hasNext()) {
            String word = (String) it.next();
            pq.offer(new ResultType(word, map.get(word)));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            results[i] = pq.poll().word;
        }

        return results;
    }
}
