package LinkedIn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sunbo on 1/11/2017.
 */
/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 */
public class Meeting_RoomsII {
    private static class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int roomsNeeded(Interval[] intervlas) {
        Arrays.sort(intervlas, Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervlas[0].end);
        for (int i = 1 ; i < intervlas.length; i++) {
            if (intervlas[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervlas[i].end);
        }
        return pq.size();
    }

}
