package xwan.leetcode.bfs_dfs_tree_backtracking;

import org.omg.PortableInterceptor.INACTIVE;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xwan on 12/30/16.
 */
public class PalindromePartitioning131 {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> path = new ArrayList<>();
        helper(s, path, res, 0);

        return res;
    }

    private static void helper(String s, List<String> path, List<List<String>> res, int idx) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                if (idx == i) {
                    path.add(s.substring(i, i + 1));
                } else {
                    path.add(s.substring(idx, i + 1));
                }
                helper(s, path, res, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        partition("aab");
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : map.keySet()) {

        }
    }
}
