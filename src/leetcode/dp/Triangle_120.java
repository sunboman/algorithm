package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunbo_000 on 10/7/2016.
 */
public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int height = triangle.size();
        int length = triangle.get(height - 1).size();
        int[] n = new int[length];

        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> line = triangle.get(i);
            int lineSize = line.size();
            int old = n[0];
            int oldFirst = n[0];
            int oldTail = lineSize > 1 ? n[lineSize - 2] : 0;
            for (int j = 1; j < lineSize - 1; j++) {
                int tmp = n[j];
                n[j] = Math.min(n[j], old) + line.get(j);
                old = tmp;
            }
            n[0] = oldFirst + line.get(0);
            n[lineSize - 1] = oldTail + line.get(lineSize - 1);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n.length; i++) {
            if (n[i] < result) result = n[i];
        }

        return result;

    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -1));
//        triangle.add(Arrays.asList(-4, -5, 4, 4));
//        triangle.add(Arrays.asList(-6, -6, 2, -1, -5));
//        triangle.add(Arrays.asList(3, 7, 8, -3, 7, -9));
        Triangle_120 solution = new Triangle_120();
        solution.minimumTotal(triangle);
    }
}
