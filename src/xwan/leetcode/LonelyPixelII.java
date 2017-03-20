package xwan.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xwan on 3/4/17.
 */
public class LonelyPixelII {
    public static int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;
        int n = picture.length;
        int m = picture[0].length;
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> column = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 'B') {
                    if (!row.containsKey(i)) row.put(i, new HashSet<>());
                    if (!column.containsKey(j)) column.put(j, new HashSet<>());
                    row.get(i).add(j);
                    column.get(j).add(i);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 'B' && row.get(i).size() == N && column.get(j).size() == N) {
                    boolean isLonely = true;
                    for (int col : column.get(j)) {
                        if (row.get(i).size() != row.get(col).size() || row.get(i).containsAll(row.get(col))) {
                            isLonely = false;
                            break;
                        }
                    }
                    if (isLonely) res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] pic = {{'W', 'B', 'W', 'B', 'B', 'W'}, {'W', 'B', 'W', 'B', 'B', 'W'},{'W', 'B', 'W', 'B', 'B', 'W'},{'W', 'W', 'B', 'W', 'B', 'W'}};
        findBlackPixel(pic, 3);
    }
}
