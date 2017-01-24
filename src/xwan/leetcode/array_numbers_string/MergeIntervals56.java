package xwan.leetcode.array_numbers_string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwan on 12/27/16.
 */
class Interval {
    int start;
    int end;

    public Interval() {
        this.start = this.end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class MergeIntervals56 {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        intervals.sort((a, b) -> (a.start - b.start));
        Interval temp = intervals.get(0);
        for (Interval curr : intervals) {
            if (curr.start > temp.end) {
                res.add(temp);
                temp = curr;
            } else {
                if (curr.end > temp.end) {
                    temp.end = curr.end;
                }
            }
        }
        res.add(temp);
        return res;
    }
    public static void main(String[] args) {
       List<Interval> intervals = new ArrayList<>();
       intervals.add(new Interval(8, 10));
       intervals.add(new Interval(15, 18));
       intervals.add(new Interval(1, 3));
       intervals.add(new Interval(2, 6));

       merge(intervals);
    }

}
