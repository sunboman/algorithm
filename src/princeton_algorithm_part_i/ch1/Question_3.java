package princeton_algorithm_part_i.ch1;

/**
 * Created by sunbo_000 on 10/10/2016.
 */

/*
Successor with delete. Given a set of N integers S={0,1,…,N−1} and a sequence of requests of the following form:
    Remove x from S
    Find the successor of x: the smallest y in S such that y≥x.

design a data type so that all operations (except construction) should take logarithmic time or better.

 */

/*
Solution:  used the dataType from Question 2. connected numbers which are deleted.

 */

public class Question_3 {

    class QuickUnionUF {
        private int[] id;
        private int[] sz;
        private int[] largest;
        private int count;

        public QuickUnionUF(int N) {
            id = new int[N];
            sz = new int[N];
            largest = new int[N];
            count = N;
            for (int i = 0; i < N; i++) {
                sz[i] = 1;
                id[i] = i;
                largest[i] = i;
            }
        }


        private int find(int i) {
            int root = root(i);
            return largest[root];
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
                largest[j] = Math.max(largest[i], largest[j]);
            } else {
                id[j] = i;
                sz[i] += sz[j];
                largest[i] = Math.max(largest[i], largest[j]);
            }
            count--;
        }
    }

    private boolean data_nexists[];
    private QuickUnionUF uf = null;
    private int N;

    public Question_3(int N) {
        this.N = N;
        uf = new QuickUnionUF(N);
        data_nexists = new boolean[N];
    }

    public void remove(int i) {
        data_nexists[i] = true;
        if (i > 0 && data_nexists[i - 1]) uf.union(i - 1, i);
        if (i < N - 1 && data_nexists[i + 1]) uf.union(i, i + 1);
    }

    public int find(int i) {
        if (!data_nexists[i]) return i;
        else {
            int result = uf.find(i) + 1;
            if(result < N) return result;
            else throw new RuntimeException("successor does not exist");
        }
    }

}
