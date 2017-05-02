package leetcode;

import java.util.*;

/**
 * Created by bosun on 5/2/17.
 */
public class Longest_Subtstring_with_at_least_k_repeating_character_395 {
  public int longestSubstring(String s, int k) {
    return getSubstring(s, k, 0, s.length() - 1);
  }

  private int getSubstring(String s, int k, int start, int end) {
    if (end - start + 1 < k) {
      return 0;
    }
    int[] count = new int[26];
    for (int i = start; i <= end; i++) {
      count[s.charAt(i) - 'a']++;
    }
    for (int i = start; i <= end; i++) {
      char c = s.charAt(i);
      if (count[c - 'a'] < k) {
        int left = getSubstring(s, k, start, i - 1);
        int right = getSubstring(s, k, i + 1, end);
        return Math.max(left, right);
      }
    }
    return end - start + 1;
  }

  public static void main(String[] args) {
    new Longest_Subtstring_with_at_least_k_repeating_character_395().longestSubstring("ababacb", 3);
  }
}
