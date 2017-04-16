package leetcode;

import java.util.*;

public class SummaryRanges {
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

  TreeMap<Integer, Interval> tree;

  /**
   * Initialize your data structure here.
   */
  public SummaryRanges() {
    tree = new TreeMap<>();
  }

  public void addNum(int val) {
    if (tree.containsKey(val)) {
      return;
    }
    Integer l = tree.lowerKey(val);
    Integer h = tree.higherKey(val);
    if (l != null && h != null && tree.get(l).end + 1 == val && val + 1 == h) {
      tree.get(l).end = tree.get(h).end;
      tree.remove(h);
    } else if (l != null && tree.get(l).end + 1 >= val) {
      tree.get(l).end = Math.max(tree.get(l).end, val);
    } else if (h != null && val + 1 == h) {
      tree.put(val, new Interval(val, tree.get(h).end));
      tree.remove(h);
    } else {
      tree.put(val, new Interval(val, val));
    }
  }

  public List<Interval> getIntervals() {
    return new ArrayList<>(tree.values());
  }
}