package xwan.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xwan on 1/24/17.
 */

/**
 *  Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
    Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.

     Example
     Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
     return [[1,1],[2,5],[4,4]]

 */
public class KClosestPoints {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    class PointComparator implements Comparator<Point> {
        private Point origin;
        public PointComparator(Point origin) {
            this.origin = origin;
        }
        public int compare(Point a, Point b) {
            int bDis = getDistance(a, origin);
            int aDis = getDistance(b, origin);
            if (bDis != aDis) {
                return aDis - bDis;
            } else if (b.x != a.x) {
                return a.x - b.x;
            } else {
                return a.y - b.y;
            }
        }
    }
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        if (points == null || points.length == 0) {
            return new Point[0];
        }

        PointComparator pointC = new PointComparator(origin);
        PriorityQueue<Point> pq = new PriorityQueue<>(k, pointC);
        for (Point p : points) {
            pq.add(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        Point[] res = new Point[pq.size()];
        int idx = pq.size() - 1;
        while (!pq.isEmpty()) {
            res[idx--] = pq.poll();
        }

        return res;
    }
    private int getDistance(Point a, Point origin) {
        int x = a.x - origin.x;
        int y = a.y - origin.y;
        return x * x + y * y;
    }

    public static void main(String[] args) {
        KClosestPoints kcp = new KClosestPoints();
        Point[] points = new Point[]{
                kcp.new Point(4, 6),
                kcp.new Point(4, 7),
                kcp.new Point(4, 4),
                kcp.new Point(2, 5),
                kcp.new Point(1, 1),
        };
        Point origin = kcp.new Point(0, 0);
        kcp.kClosest(points, origin, 30);

    }
}
