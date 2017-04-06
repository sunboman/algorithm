package leetcode;

import java.util.*;

/**
 * Created by bosun on 4/6/17.
 */
public class Longest_Uncommon_Subsequence_II_522 {
  public static int findLUSlength(String[] strs) {
    if (strs == null || strs.length == 0) {
      return -1;
    }
    Arrays.sort(strs, (a, b) -> {
      if (a.length() != b.length()) {
        return b.length() - a.length();
      } else {
        return a.compareTo(b);
      }
    });
    int n = strs.length;
    A:
    for (int i = 0; i < n; i++) {
      if ((i > 0 && strs[i].equals(strs[i - 1])) || (i < n - 1 && strs[i].equals(strs[i + 1]))) {
        continue;
      }
      for (int j = 0; j < i; j++) {
        if (!isSub(strs[i], strs[j])) {
          return strs[i].length();
        } else {
          continue A;
        }
      }
    }
    return -1;
  }

  private static boolean isSub(String a, String b) {
    int n = a.length(), m = b.length(), idx = 0;
    for (int i = 0; i < m; i++) {
      if (idx < n && a.charAt(idx) == b.charAt(i)) {
        idx++;
      }
    }
    if (idx == n) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int res = findLUSlength(new String[]{"a","b","c","d","e","f","a","b","c","d","e","f"});
  }
}
