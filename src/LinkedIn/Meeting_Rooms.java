package LinkedIn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sunbo on 1/11/2017.
 */
/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 */
public class Meeting_Rooms {
    private static class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public boolean attendAll(Interval[] intervlas) {
        Arrays.sort(intervlas, Comparator.comparingInt(a -> a.start));
        for (int i = 0 ; i < intervlas.length - 1; i++) {
            int leftEnd = intervlas[i].end;
            int rightStart = intervlas[i + 1].start;
            if (leftEnd > rightStart) {
                return false;
            }
        }
        return true;
    }

}
