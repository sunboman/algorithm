package xwan.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwan on 2/4/17.
 */

/**
 * leetcode contest 28A
 */
public class FindSameRowWord {
    public static String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }
        String firRow = "qwertyuiopQWERTYUIOP";
        String secRow = "asdfghjklASDFGHJKL";
        String thirRow = "zxcvbnmZXCVBNM";

        List<String> temp = new ArrayList<>();
        for (String word : words) {
            int fircount = 0;
            int seccount = 0;
            int thcount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (firRow.indexOf(word.substring(i, i + 1)) >= 0) {
                    fircount++;
                }
                if (secRow.indexOf(word.substring(i, i + 1)) >= 0) {
                    seccount++;
                }
                if (thirRow.indexOf(word.substring(i, i + 1)) >= 0) {
                    thcount++;
                }
            }
            if (fircount == word.length() || seccount == word.length() || thcount == word.length()) {
                temp.add(word);
            }
        }
        String[] res = new String[temp.size()];
        int idx = 0;
        for (String str : temp) {
            res[idx++] = str;
        }

        return res;
    }


    public static void main(String[] args) {

        findWords(new String[]{"Hello","Alaska","Dad","Peace"});
        System.out.println("ad".indexOf("a"));
    }
}
