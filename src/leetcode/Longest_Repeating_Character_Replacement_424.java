package leetcode;

/**
 * Created by bosun on 5/2/17.
 */
public class Longest_Repeating_Character_Replacement_424 {
  public int characterReplacement(String s, int k) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int[] count = new int[26];
    int left = 0, res = 0, maxCount = 0, n = s.length();
    for (int right = 0; right < n; right++) {
      maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);
      while (right - left + 1 - maxCount > k) {
        count[s.charAt(left++) - 'a']--;
      }
      res = Math.max(res, right - left + 1);
    }
    return res;
  }

  public static void main(String[] args) {
    new Longest_Repeating_Character_Replacement_424().characterReplacement("ABAB", 2);
  }
}
