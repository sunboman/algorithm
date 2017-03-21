package Evernote;


import java.util.*;

/**
 * Created by bosun on 2/24/17.
 */
public class Phone_Interview {

  public static List<String> allValid(String str) {
    if (str == null || str.length() == 0) {
      return new ArrayList<>(0);
    }
    List<String> res = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      res.addAll(getSubstring(str.substring(i)));
    }
    return res;
  }

  private static List<String> getSubstring(String str) {
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();
    int n = str.length();
    for (int i = 0; i < n; i++) {
      sb.append(str.charAt(i));
      res.add(sb.toString());
    }
    return res;
  }

  public static List<String> getEqualSubstring(String str) {
    int n = str.length();
    int count = 0;
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (str.charAt(i) == '*') {
        count++;
      } else {
        count--;
      }
      if (!map.containsKey(count)) {
        List<Integer> temp = new ArrayList<>();
        temp.add(i);
        map.put(count, temp);
      } else {
        List<Integer> temp = map.get(count);
        temp.add(i);
        map.put(count, temp);
      }
    }
    List<String> res = new ArrayList<>();
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      if (entry.getValue().size() <= 1) {
        continue;
      }
      List<Integer> list = entry.getValue();
      int m = list.size();
      for (int i = 0; i < m; i++) {
        for (int j = i + 1; j < m; j++) {
          res.add(str.substring(list.get(i) + 1, list.get(j) + 1));
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    getEqualSubstring("**##*").forEach(System.out::print);
  }
}
