package leetcode;

import java.util.*;

/**
 * Created by bosun on 4/24/17.
 */
public class Text_justification_68 {
  public List<String> fullJustify(String[] words, int maxWidth) {
    if (words == null || words.length == 0) return new ArrayList<>(0);
    List<String> result = new ArrayList<>();
    int n = words.length;
    int count = 0;
    int last = 0;
    for (int i = 0; i < n; i++) {
      count += words[i].length();
      if (count + i - last <= maxWidth) continue;
      int wordsLen = count - words[i].length();
      int spaceLen = maxWidth - wordsLen;
      int eachLen = 1;
      int spareLen = 0;
      if (i - last - 1 > 0) {
        eachLen = spaceLen / (i - last - 1);
        spareLen = spaceLen % (i - last - 1);
      } else {
        eachLen = 0;
        spareLen = spaceLen;
      }
      StringBuilder sb = new StringBuilder();
      String eachSpace = genSpace(eachLen);
      for (int j = last; j < i - 1; j++) {
        sb.append(words[j]).append(eachSpace);
        if (spareLen > 0) {
          spareLen--;
          sb.append(" ");
        }
      }
      sb.append(words[i - 1]);
      if (spareLen != 0) sb.append(genSpace(spareLen));
      result.add(sb.toString());
      last = i;
      count = words[i].length();
    }
    StringBuilder sb = new StringBuilder();
    for (int i = last; i < n - 1; i++) {
      sb.append(words[i]).append(" ");
    }
    sb.append(words[n - 1]);
    sb.append(genSpace(maxWidth - sb.length()));
    result.add(sb.toString());
    return result;
  }

  private String genSpace(int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) sb.append(" ");
    return sb.toString();
  }

  public static void main(String[] args) {
    new Text_justification_68().fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."}, 6);
  }
}
