package xwan.linkedin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xwan on 2/16/17.
 */

/**
 *
 * 127. Word Ladder
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        Set<String> wordsDict = new HashSet<>();
        for (String s : wordList) {
            wordsDict.add(s);
        }
        wordsDict.remove(beginWord);
        int len = 1;
        while (!reached.isEmpty()) {
            Set<String> toAdd = new HashSet<>();
            for (String word : reached) {
                for (int i = 0; i < word.length(); i++) {
                    char[] charArray = word.toCharArray();
                    for (char ch = 'a'; ch < 'z'; ch++) {
                        charArray[i] = ch;
                        String newWord = String.valueOf(charArray);
                        if (wordsDict.contains(newWord)) {
                            toAdd.add(newWord);
                            wordsDict.remove(newWord);
                        }
                    }
                }
            }
            len++;
//            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return len;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        String dd = "hot";
//        System.out.println(wordList.indexOf(dd));
        ladderLength("hit", "cog", wordList);
    }
}
