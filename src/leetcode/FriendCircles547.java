package leetcode;

/**
 * Created by xwan on 4/15/17.
 */

/**
 * 547 Friend Circles
 *
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

 Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

 Example 1:
 Input:
 [[1,1,0],
 [1,1,0],
 [0,0,1]]
 Output: 2
 Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 The 2nd student himself is in a friend circle. So return 2.
 Example 2:
 Input:
 [[1,1,0],
 [1,1,1],
 [0,1,1]]
 Output: 1
 Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 Note:
 N is in range [1,200].
 M[i][i] = 1 for all students.
 If M[i][j] = 1, then M[j][i] = 1.
 */
public class FriendCircles547 {
    static class UnionFind {
        private int count = 0;
        private int[] father, rank;

        public UnionFind(int n) {
            count = n;
            father = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        public int find(int p) {
            while (p != father[p]) {
                father[p] = father[father[p]];
                p = father[p];
            }
            return p;
        }
        public void union(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a == root_b) return;
            if (rank[root_a] < rank[root_b]) {
                rank[root_a] = root_b;
            } else {
                rank[root_b] = root_a;
                if (rank[root_a] == rank[root_b]) rank[root_a]++;
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }
    public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }

        return uf.count;
    }


    public static int findCircleNum_dfs(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int count = 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                helper(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private static void helper(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                helper(M, visited, j);
            }
        }
    }
    public static void main(String[] args) {
        int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(M));
        System.out.println(findCircleNum_dfs(M));
    }
}
