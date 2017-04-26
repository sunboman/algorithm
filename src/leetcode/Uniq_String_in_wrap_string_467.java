package leetcode;

import java.util.*;

/**
 * Created by bosun on 4/26/17.
 */
public class Uniq_String_in_wrap_string_467 {
  public int findSubstringInWraproundString(String p) {
    if (p == null || p.length() == 0) return 0;
    Map<Character, String> map = new HashMap<>();
    int n = p.length();
    int l = 0;
    for (int i = 0; i <= n; i++) {
      if (i == n) {
        for (int j = l; j < i; j++)
          map.put(p.charAt(j), map.getOrDefault(p.charAt(j), "").length() > i - j ? map.get(p.charAt(j)) : p.substring(j, i));
        break;
      }
      if (i == l) continue;
      if (p.charAt(i - 1) == 'z' && p.charAt(i) == 'a') continue;
      if (p.charAt(i) - p.charAt(i - 1) == 1) continue;
      for (int j = l; j < i; j++)
        map.put(p.charAt(j), map.getOrDefault(p.charAt(j), "").length() > i - j ? map.get(p.charAt(j)) : p.substring(j, i));
      l = i;
    }
    int res = 0;
    for (String str : map.values()) res += str.length();
    return res;
  }

  public static void main(String[] args) {
    new Uniq_String_in_wrap_string_467().findSubstringInWraproundString("uvwxyzabcdefg");
  }
}
