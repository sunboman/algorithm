package xwan.leetcode.dinamic_programming;

import java.util.Set;

/**
 * Created by xwan on 12/29/16.
 */
public class WordBreak139 {
    public boolean wordBreak_1(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String str : wordDict) {
                int end = i + str.length();
                if (end > n || dp[end]) {
                    continue;
                }
                if (s.substring(i, end).equals(str)) {
                    dp[end] = true;
                }
            }
        }
        return dp[n];
    }
    public boolean wordBreak_2(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
