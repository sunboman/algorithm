package princeton_algorithm_part_i.ch1.quiz1;

/**
 * Created by sunbo_000 on 10/10/2016.
 */
/*
Union-find with specific canonical element. Add a method find() to the union-find data type so that find(i) returns the
largest element in the connected component containing i. The operations, union(), connected(), and find() should all take
logarithmic time or better.

For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9 for each of the four elements in the connected components.
 */

/*
Solution: use a array largest,  largest[i] store the largest number of the component with root i
 */

public class Question_2 {
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
                largest[j] = Math.max(largest[i],largest[j]);
            } else {
                id[j] = i;
                sz[i] += sz[j];
                largest[i] = Math.max(largest[i],largest[j]);
            }
            count--;
        }
    }
}
