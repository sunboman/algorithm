package princeton_algorithm_part_i.ch1;

/**
 * Created by sunbo_000 on 10/9/2016.
 */

/*
Social network connectivity. Given a social network containing n members and a log file containing m timestamps at which
 times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are
 connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted
  by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be mlogn or better
  and use extra space proportional to n.
 */

/*
Solution:
    Used union-find as data structure.
    Used an int count to calculate the number of connected people. When all people are connected, count will be 1.
 */

public class Question_1 {
    class QuickUnionUF {
        private int[] id;
        private int[] sz;
        private int count;

        public QuickUnionUF(int N) {
            id = new int[N];
            sz = new int[N];
            count = N;
            for (int i = 0; i < N; i++) {
                sz[i] = 1;
                id[i] = i;
            }
        }

        public int count() {
            return count;
        }

        private int root(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (i == j) return;
            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
            } else {
                id[j] = i;
                sz[i] += sz[j];
            }
            count--;
        }
    }
}
