package leetcode;

import java.util.*;

/**
 * Created by bosun on 5/3/17.
 */
public class Is_Subsequence_392 {
  public boolean isSubsequence(String s, String t) {
    List<Integer>[] idxList = new List[26];
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (idxList[c - 'a'] == null) idxList[c - 'a'] = new ArrayList<>();
      idxList[c - 'a'].add(i);
    }
    int tIdx = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (idxList[c - 'a'] == null) {
        return false;
      }
      int j = Collections.binarySearch(idxList[c - 'a'], tIdx);
      if (j < 0) j = - (j + 1);
      if (j >= idxList[c - 'a'].size()) {
        return false;
      }
      tIdx = idxList[c - 'a'].get(j) + 1;
    }
    return true;

  }

  public static void main(String[] args) {
    new Is_Subsequence_392().isSubsequence("ab", "abc");
  }
}
