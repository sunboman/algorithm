package Amazon_OA;

import java.util.Comparator;
import java.util.PriorityQueue;

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
    public Point[] Solution(Point[] array, Point origin, int k) {
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
        return Math.sqrt(x * x + y * y);
    }
}
