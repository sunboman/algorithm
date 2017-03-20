package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunbo on 3/10/2017.
 */
public class Zuma_Game_488 {
  public static int findMinStep(String board, String hand) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('R', 0);
    map.put('Y', 0);
    map.put('B', 0);
    map.put('G', 0);
    map.put('W', 0);
    for (int i = 0; i < hand.length(); i++) {
      char c = hand.charAt(i);
      map.put(c, map.get(c) + 1);
    }
    int res = find(board, map, new HashMap<String, Integer>());
    if (res >= 6) {
      return -1;
    } else {
      return res;
    }
  }

  private static int find(String board, Map<Character, Integer> map, Map<String, Integer> cache) {
    if (board.length() == 0) {
      return 0;
    }
    int min = 6;
    for (int i = 0; i < board.length(); i++) {
      char c = board.charAt(i);
      if (map.get(c) == 0 || (i > 0 && c == board.charAt(i - 1))) {
        continue;
      }
      map.put(c, map.get(c) - 1);
      String newBoard = remove(board.substring(0, i) + c + board.substring(i));
      String key = hash(newBoard, map);
      if (cache.containsKey(key)) {
        min = Math.min(min, 1 + cache.get(key));
      } else {
        int next = find(newBoard, map, cache);
        min = Math.min(min, 1 + next);
        cache.put(key, min);
      }
      map.put(c, map.get(c) + 1);
    }
    return min;
  }

  private static String remove(String board) {
    if (board.length() == 0) {
      return "";
    }
    int count = 1;
    for (int i = 1; i < board.length(); i++) {
      if (board.charAt(i) == board.charAt(i - 1)) {
        count++;
      } else {
        if (count >= 3) {
          return remove(board.substring(0, i - count) + board.substring(i));
        } else {
          count = 1;
        }
      }
    }
    if (count >= 3) {
      return board.substring(0, board.length() - count);
    } else {
      return board;
    }
  }

  private static String hash(String board, Map<Character, Integer> map) {
    StringBuilder sb = new StringBuilder(board);
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      sb.append(entry.getKey()).append(entry.getValue());
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    findMinStep("WWRRBBWW", "WRBRW");
    String a = "";
  }
}
