package LinkedIn;

import java.util.*;

/**
 * Created by sunbo on 12/29/2016.
 */
/*
Word1 and Word2 can be equal
 */
public class Shortest_Word_Distance_III {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word1.equals(word2)) {
                if (word.equals(word1)) {
                    if (index1 > index2) {
                        index2 = i;
                    } else {
                        index1 = i;
                    }
                }
            } else {
                if (word.equals(word1)) {
                    index1 = i;
                }
                if (word.equals(word2)) {
                    index2 = i;
                }
            }
            if (index1 != -1 && index2 != -1) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }
}
