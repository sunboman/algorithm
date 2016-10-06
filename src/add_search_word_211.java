import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunbo_000 on 10/5/2016.
 */
public class add_search_word_211 {
    public static class WordDictionary {

        TreeNode head = new TreeNode(false);

        // Adds a word into the data structure.
        public void addWord(String word) {
            TreeNode node = head;
            for (int i = 0; i < word.length(); i++) {
                if (!node.children.containsKey(word.charAt(i))) {
                    if (i != word.length() - 1)
                        node.children.put(word.charAt(i), new TreeNode(false));
                    else
                        node.children.put(word.charAt(i), new TreeNode(true));
                    node = node.children.get(word.charAt(i));
                } else {
                    node = node.children.get(word.charAt(i));
                }
            }
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return searchNode(word, head);
        }

        public boolean searchNode(String word, TreeNode node) {
            if (node == null) return false;
            if (word.length() == 0) return node.isWord;

            char c = word.charAt(0);
            Map<Character, TreeNode> children = node.children;
            if (c == '.') {
                for (char b : children.keySet()) {
                    if (searchNode(word.substring(1), children.get(b))) return true;
                }
                return false;
            } else if (!children.containsKey(c)) {
                return false;
            } else {
                return searchNode(word.substring(1), children.get(c));
            }
        }
    }

    static class TreeNode {
        boolean isWord;

        Map<Character, TreeNode> children = new HashMap<>();

      /*  public TreeNode(char c) {
            this.current = c;
        }*/

        public TreeNode(boolean isWord) {
            this.isWord = isWord;
        }


    }

    // Your WordDictionary object will be instantiated and called as such:
    // WordDictionary wordDictionary = new WordDictionary();
    // wordDictionary.addWord("word");
    // wordDictionary.search("pattern");

    public static void main(String[] args) {
        WordDictionary solution = new WordDictionary();
        solution.addWord("a");
        solution.addWord("a");
        System.out.println(solution.search("."));
        System.out.println(solution.search("a"));
        System.out.println(solution.search("aa"));
        System.out.println(solution.search("a"));
        System.out.println(solution.search(".a"));
        System.out.println(solution.search("a."));
        String a = "";

    }
}
