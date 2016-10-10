package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by sunbo_000 on 10/10/2016.
 */
public class Word_Break_II_140 {
    public static List<String> wordBreak(String s, Set<String> dict) {
        //create an array of ArrayList<String>
        List<String> dp[] = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == null)
                continue;

            for (String word : dict) {
                int len = word.length();
                int end = i + len;
                if (end > s.length())
                    continue;

                if (s.substring(i, end).equals(word)) {
                    if (dp[end] == null) dp[end] = new ArrayList<>();
                    dp[end].add(word);
                }
            }
        }

        List<String> result = new LinkedList<>();
        if (dp[s.length()] == null)
            return result;

        ArrayList<String> temp = new ArrayList<>();
        dfs(dp, s.length(), result, temp);

        return result;
    }

    public static void dfs(List<String> dp[], int end, List<String> result, ArrayList<String> tmp) {
        if (end <= 0) {
            String path = tmp.get(tmp.size() - 1);
            for (int i = tmp.size() - 2; i >= 0; i--) {
                path += " " + tmp.get(i);
            }
            result.add(path);
            return;
        }

        for (String str : dp[end]) {
            tmp.add(str);
            dfs(dp, end - str.length(), result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
