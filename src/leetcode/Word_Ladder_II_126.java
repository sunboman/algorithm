package leetcode;
import java.util.*;
/**
 * Created by sunbo on 2/8/2017.
 */
public class Word_Ladder_II_126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> unvisited = new HashSet<>();
        Set<String> visited = new HashSet<>();
        unvisited.addAll(wordList);
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.offer(new WordNode(beginWord, 1, null));
        int finalSteps = Integer.MAX_VALUE;
        List<List<String>> res = new ArrayList<>();
        int preLevel = 0;
        while (!queue.isEmpty()) {
            WordNode node = queue.poll();
            if (node.word.equals(endWord)) {
                finalSteps = Math.min(finalSteps, node.level);
                if (node.level <= finalSteps) {
                    if (node.level < finalSteps) {
                        res = new ArrayList<>();
                    }
                    LinkedList<String> temp = new LinkedList<>();
                    while (node != null) {
                        temp.push(node.word);
                        node = node.prev;
                    }
                    res.add(new ArrayList<>(temp));
                    continue;
                }
            }
            if (node.level > preLevel) {
                unvisited.removeAll(visited);
            }
            preLevel = node.level;
            char[] chars = node.word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == temp) {
                        continue;
                    }
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (unvisited.contains(newWord)) {
                        visited.add(newWord);
                        queue.offer(new WordNode(newWord, node.level + 1, node));
                    }
                    chars[i] = temp;
                }
            }
        }
        return res;
    }
    private class WordNode {
        WordNode prev;
        int level;
        String word;
        public WordNode(String word, int level, WordNode prev) {
            this.prev = prev;
            this.level = level;
            this.word = word;
        }
    }
}
