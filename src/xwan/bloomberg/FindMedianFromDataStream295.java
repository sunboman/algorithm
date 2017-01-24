package xwan.bloomberg;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xwan on 1/3/17.
 */
public class FindMedianFromDataStream295 {
    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;
    public FindMedianFromDataStream295() {
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (!maxPq.isEmpty() && num < maxPq.peek()) {
            maxPq.add(num);
        } else {
            minPq.add(num);
        }

        if (maxPq.size() > minPq.size()) {
            minPq.add(maxPq.poll());
        }
        if (minPq.size() > maxPq.size() + 1) {
            maxPq.add(minPq.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minPq.size() == maxPq.size()) {
            return (double) (minPq.peek() + maxPq.peek()) / 2;
        } else {
            return (double )minPq.peek();
        }
    }
    public static void main(String[] args) {
        FindMedianFromDataStream295 test = new FindMedianFromDataStream295();
        test.addNum(2);
        System.out.println(test.findMedian());
        test.addNum(3);
        System.out.println(test.findMedian());
    }
}
