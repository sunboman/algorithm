package princeton_algorithm_part_i.ch1.quiz1;

/**
 * Created by sunbo_000 on 10/10/2016.
 */
/*
http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
 */

public class Assignment_1 {

    static class QuickUnionUF {
        private int[] id;
        private int[] sz;
        private int[] least;
        private int count;

        public QuickUnionUF(int N) {
            id = new int[N];
            sz = new int[N];
            least = new int[N];
            count = N;
            for (int i = 0; i < N; i++) {
                sz[i] = 1;
                id[i] = i;
                least[i] = i;
            }
        }


        private int find(int i) {
            int root = root(i);
            return least[root];
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
                least[j] = Math.min(least[i], least[j]);
            } else {
                id[j] = i;
                sz[i] += sz[j];
                least[i] = Math.min(least[i], least[j]);
            }
            count--;
        }
    }

    public static class Percolation {

        private int n;
        private boolean[] isOpen;
        private QuickUnionUF uf;

        // create n-by-n grid, with all sites blocked
        public Percolation(int n) {
            if (n <= 0) throw new IllegalArgumentException();
            this.n = n;
            isOpen = new boolean[n * n];
            uf = new QuickUnionUF(n * n);
        }

        // open site (row i, column j) if it is not open already
        public void open(int i, int j) {
            if (i < 0 || i > n || j < 0 || j > n) throw new IndexOutOfBoundsException();
            isOpen[i * n + j] = true;
            if (i > 0 && isOpen(i - 1, j)) uf.union((i - 1) * n + j, i * n + j);
            if (i < n - 1 && isOpen(i + 1, j)) uf.union((i + 1) * n + j, i * n + j);
            if (j > 0 && isOpen(i, j - 1)) uf.union(i * n + j - 1, i * n + j);
            if (j < n - 1 && isOpen(i, j + 1)) uf.union(i * n + j + 1, i * n + j);
        }

        // is site (row i, column j) open?
        public boolean isOpen(int i, int j) {
            if (i < 0 || i > n || j < 0 || j > n) throw new IndexOutOfBoundsException();
            return isOpen[i * n + j];
        }

        // is site (row i, column j) full?
        public boolean isFull(int i, int j) {
            if (i < 0 || i > n || j < 0 || j > n) throw new IndexOutOfBoundsException();
            return uf.find(i * n + j) < n;
        }

        // does the system percolate?
        public boolean percolates() {
            for (int i = 0; i < n; i++) {
                if (isFull(n - 1, i)) return true;
            }
            return false;
        }

        // test client (optional)
        public static void main(String[] args) {

            Percolation solution = new Percolation(4);
            solution.open(0, 0);
            solution.open(0, 1);
            solution.open(1, 1);
            solution.open(1, 2);
            solution.open(2, 2);
            solution.open(3, 2);
            System.out.println(solution.isFull(1, 0));
            System.out.println(solution.percolates());
        }
    }
}
