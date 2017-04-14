package leetcode;

import java.util.TreeMap;


public class Find_Right_Interval_436 {
  private class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

  public int[] findRightInterval(Interval[] intervals) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int n = intervals.length;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      map.put(intervals[i].start, i);
    }
    for (int i = 0; i < n; i++) {
      Integer idx = map.ceilingKey(intervals[i].end);
      res[i] = idx == null ? -1 : map.get(idx);
    }
    return res;
  }

}
