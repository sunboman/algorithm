package LinkedIn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by sunbo on 11/28/2016.
 */



public class K_Closest_Point {
    class Point {
        double x;
        double y;

        public Point(double a, double b) {
            x = a;
            y = b;
        }
    }
    public Point[] heapSolution(Point[] array, Point origin, int k) {
        if (array == null || array.length < k) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> getDistance(a, origin)));
        for (Point point : array) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        Point[] result = new Point[k];
        pq.toArray(result);
        return result;
    }

    private double getDistance(Point a, Point origin) {
        double x = a.x - origin.x;
        double y = a.y - origin.y;
        return Math.sqrt(x * x - y * y);
    }

    public Point[] quickSolution(Point[] points, Point origin, int k) {
        quickSelect(points, k - 1, 0, points.length - 1, origin);
        Point[] res = new Point[k];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private void quickSelect(Point[] points, int k, int left, int right, Point origin) {
        int random = new Random().nextInt(right - left + 1) + left;
        swap(points, left, random);
        Point pivot = points[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && getDistance(points[l], origin) <= getDistance(pivot, origin)) {
                l++;
            }
            points[r] = points[left];
            while (l < r && getDistance(points[r], origin) >= getDistance(pivot, origin)) {
                r--;
            }
            points[l] = points[r];
        }
        points[l] = pivot;
        if (l == k) {
            return;
        } else if (l > k) {
            quickSelect(points, k, left, l - 1, origin);
        } else {
            quickSelect(points, k, l + 1, right, origin);
        }
    }
    private void swap(Point[] points, int i, int j) {
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
