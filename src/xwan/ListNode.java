package xwan;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xwan on 10/30/16.
 */
public class ListNode {

    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }


    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        if (nums.length == 1) {
            res[0] = res[1] = 0;
            return res;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
            map.put(sum, i);
        }

        Arrays.sort(nums);

        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (minVal > nums[i] - nums[i - 1]) {
                minVal = nums[i] - nums[i - 1];
                int left = map.get(nums[i - 1]);
                int right = map.get(nums[i]);

                res[0] = Math.min(left, right) + 1;
                res[1] = Math.max(left, right);

                return res;
            }
        }

        return res;
    }

    public static List<Integer> mergekSortedArrays(int[][] arrays) {
        List<Integer> res = new ArrayList<>();
        if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return res;
        }
        if (arrays.length == 1) {
            for (int i = 0; i < arrays[0].length; i++) {
                res.add(arrays[0][i]);
            }
            return res;
        }

        res = mergeTwo(arrays[0], arrays[1]);
        for (int i = 2; i < arrays.length; i++) {
            int[] tmpArr = convertListToInt(res);
            res = mergeTwo(tmpArr, arrays[i]);
        }

        return res;
    }

    private static int[] convertListToInt(List<Integer> list) {
        int[] res = new int[list.size()];
        int idx = 0;
        for (int elem : list) {
            res[idx++] = elem;
        }

        return res;
    }

    private static List<Integer> mergeTwo(int[] a, int[] b) {
       List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result.add(a[i]);
                i++;
            } else {
                result.add(b[j]);
                j++;
            }
        }

        while (i < a.length) {
            result.add(a[i]);
            i++;
        }
        while (j < b.length) {
            result.add(b[j]);
            j++;
        }

        return result;
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = nums[0];
        int minSize = Integer.MAX_VALUE;
        int l = 0;
        int r = 1;
        int len = nums.length;
        while (l < r && r < len) {
            if (nums[l] >= s || nums[r] >= s) {
                return 1;
            }
            sum += nums[r];
            if (sum >= s) {
                minSize = Math.min(minSize, r - l + 1);
                sum -= nums[l];
                l++;
            } else {
                r++;
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }


    public static int minSubArrayLenNlgN(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = nums[0];
        int minSize = Integer.MAX_VALUE;
        int len = nums.length;
        int[] sumArr = new int[len];
        sumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i];
        }

        for (int i = len - 1; i >= 0; i--) {
            int lo = binarySearch(sumArr, 0, len - 1, sumArr[i] - s);
            minSize = Math.min(minSize, i - lo + 1);
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static double sqrt(double x) {
        // Write your code here
        if (x == 0.0) {
            return x;
        }

        double res = 1.0;
        while (res < x / res) {
            res = 2* res;
        }
        if (res == x / res) {
            return res;
        }

        double lo = res / 2.0;
        double hi = res;
        while (lo < hi) {
            double mid = lo + (hi - lo) / 2.0;
            if (mid == x / mid ) {
                return mid;
            } else if (mid < x / mid) {
                res = mid;
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return res;
    }

    public static int mountainSequence(int[] nums) {
        int len = nums.length;
        int lo = 0;
        int hi = len - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid > 0 && mid < len - 1) {
                if (nums[mid] > nums[mid - 1] &&
                        nums[mid] > nums[mid + 1]) {
                    return nums[mid];
                } else if (nums[mid] > nums[mid - 1] &&
                        nums[mid] < nums[mid + 1]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (mid == 0 || mid == len - 1) {
                return nums[mid];
            }
        }

        return nums[lo] < nums[hi] ? nums[hi] : nums[lo];
    }


    class Pair {
        int x;
        int y;
        int sum;

        public Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
    class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair a, Pair b) {
            return a.sum - b.sum;
        }
    }


    int[] dx = new int[]{0, 1};
    int[] dy = new int[]{1, 0};

    private boolean isValid(int x, int y, int[] A, int[] B, boolean[][] visited) {
        if (x < A.length && y < B.length && !visited[x][y]) {
            return true;
        }
        return false;
    }

    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        int n = A.length;
        int m = B.length;

        boolean[][] visited = new boolean[n][m];

        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new PairComparator());
        pq.add(new Pair(0, 0, A[0] + B[0]));

        for (int i = 0; i < k - 1; i++) {
            Pair smallest = pq.poll();

            for (int j = 0; j < 2; j++) {
                int nextX = smallest.x + dx[j];
                int nextY = smallest.y + dy[j];

                if (isValid(nextX, nextY, A, B, visited)) {
                    visited[nextX][nextY] = true;
                    int nextSum = A[nextX] + B[nextY];

                    pq.add(new Pair(nextX, nextY, nextSum));
                }
            }
        }

        return pq.peek().sum;
    }


    // word break II

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        // Write your code here
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        boolean[] canBreak = new boolean[s.length()];
        Arrays.fill(canBreak, true);
        StringBuilder sb = new StringBuilder();

        dfs(s, sb, 0, result, canBreak, wordDict);

        return result;
    }

    private static void dfs(String s, StringBuilder sb, int pos, List<String> result,
                     boolean[] canBreak, Set<String> wordDict) {
        if (pos == s.length()) {
            result.add(sb.substring(1));
            return;
        }

        if (!canBreak[pos]) {
            return;
        }

        for (int i = pos + 1; i <= s.length(); i++) {
            String word = s.substring(pos, i);

            if (!wordDict.contains(word)) {
                continue;
            }

            int backtrackingStartIdx = sb.length();
            sb.append(" " + word);

            int breakableStartIdx = result.size();
            dfs(s, sb, i, result, canBreak, wordDict);
            if (breakableStartIdx == result.size()) {
                canBreak[i] = false;
            }

            sb.delete(backtrackingStartIdx, sb.length());
        }
    }


    public static void main(String[] args) {
        int[] aa = {1, 7, 11};
        int[] bb = {2, 4, 6};

        Set<String> wordDict = new HashSet<>();
        wordDict.add("de");
        wordDict.add("ding");
        wordDict.add("co");
        wordDict.add("code");
        wordDict.add("lint");

        System.out.print(wordBreak("lintcode", wordDict));
    }
}
