package leetcode;

import java.util.*;

/**
 * Created by bosun on 5/10/17.
 */
/*
Problem Description:

There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, wherewords are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Note:

You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 */
public class Alien_Dictionary_269 {
  public String alienOrder(List<String> input) {
    boolean[][] adj = new boolean[26][26];
    int[] visited = new int[26];
    Arrays.fill(visited, -1);
    buildGraph(input, adj, visited);
    StringBuilder path = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if (visited[i] == 0) {
        if (!dfs(adj, visited, i, path)) {
          return "";
        }
      }
    }
    return path.reverse().toString();
  }

  private boolean dfs(boolean[][] adj, int[] visited, int i, StringBuilder path) {
    visited[i] = 1;
    for (int j = 0; j < 26; j++) {
      if (adj[i][j]) {
        if (visited[j] == 1) return false;
        if (visited[j] == 0) {
          if (!dfs(adj, visited, j, path)) {
            return false;
          }
        }
      }
    }
    visited[i] = 2;
    path.append((char) (i + 'a'));
    return true;
  }

  private void buildGraph(List<String> input, boolean[][] adj, int[] visited) {
    int n = input.size();
    for (int i = 0; i < n; i++) {
      String s = input.get(i);
      for (char c : s.toCharArray()) {
        visited[c - 'a'] = 0;
      }
      if (i > 0) {
        String p = input.get(i - 1);
        int len = Math.min(p.length(), s.length());
        for (int j = 0; j < len; j++) {
          if (p.charAt(j) != s.charAt(j)) {
            adj[p.charAt(j) - 'a'][s.charAt(j) - 'a'] = true;
            break;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    String[] str = new String[]{"wrt",
            "wrf",
            "er",
            "ett",
            "rftt"
    };
    list.addAll(Arrays.asList(str));
    String res = new Alien_Dictionary_269().alienOrder(list);
  }
}
