package xwan;

import java.time.LocalTime;
import java.util.*;

/**
 * Created by xwan on 12/2/16.
 */
public class test {

    static int capacity;
    static int[] stack;
    static int[] stackPoint;

    public test(int size) {
        // do intialization if necessary
        capacity = size;
        stack = new int[3 * capacity];
        stackPoint = new int[3];

    }

    public static void push(int stackNum, int value) {
        // Write your code here
        // Push value into stackNum stack
        int idx = stackNum * capacity + stackPoint[stackNum];
        stack[idx] = value;
        stackPoint[stackNum]++;

    }

    public static int pop(int stackNum) {
        // Write your code here
        // Pop and return the top element from stackNum stack
        int topIdx = stackNum * capacity + stackPoint[stackNum];

        stackPoint[stackNum]--;
        int top = stack[topIdx - 1];
        stack[topIdx] = 0;
        return top;
    }

    public static int peek(int stackNum) {
        // Write your code here
        // Return the top element
        int topIdx = stackNum * capacity + stackPoint[stackNum];
        return stack[topIdx];
    }

    public static boolean isEmpty(int stackNum) {
        // Write your code here
        return stackPoint[stackNum] == 0;
    }


    public static int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ') {
                while (i < len && s.charAt(i) != ' ') {
                    i++;
                }
                count++;
            }
            while (i < len && s.charAt(i) == ' ') {
                i++;
            }
        }

        return count;
    }


    public static int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }

        int[] counts = new int[26];

        int maxLengthStr = 0;
        int len = p.length();


        for (int i = 0; i < len; i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 ||
                p.charAt(i - 1) - p.charAt(i) == 25)) {
                maxLengthStr++;
            } else {
                maxLengthStr = 1;
            }

            int idx = p.charAt(i) - 'a';
            counts[idx] = Math.max(counts[idx], maxLengthStr);
        }

        int sum = 0;
        for (int i = 0; i < counts.length; i++) {
            sum += counts[i];
        }

        return sum;
    }


    public static int divide(int dividend, int divisor) {
        // Write your code here
        if (divisor == 0) {
            return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (dividend == 0 || dividend < divisor) {
            return 0;
        }

        boolean isNegtive = (dividend > 0 && divisor < 0) ||
                (dividend < 0 && divisor > 0);

        long divid = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);

        long res = helper(divid, divis);

        int ans;
        if (res > Integer.MAX_VALUE) {
            ans = isNegtive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            ans = isNegtive ? (int) -res : (int) res;
        }

        return ans;
    }

    private static long helper(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }

        long sum = divisor;
        long mul = 1;

        while ((sum + sum) <= dividend) {
            sum += sum;
            mul += mul;
        }

        return mul + helper(dividend - sum, divisor);
    }


    public int trapRainWaterii(int[][] heights) {
        // write your code here
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int n = heights.length;
        int m = heights[0].length;

        int[][] visited = new int[n][m];

        PriorityQueue<Cell> pq = new PriorityQueue<>(1, new CellComparator());

        for (int i = 0; i < n; i++) {
            pq.offer(new Cell(i, 0, heights[i][0]));
            pq.offer(new Cell(i, m - 1, heights[i][m - 1]));

            visited[i][0] = 1;
            visited[i][m - 1] = 1;
        }

        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(0, i, heights[0][i]));
            pq.offer(new Cell(n - 1, i, heights[n - 1][i]));

            visited[0][i] = 1;
            visited[n - 1][i] = 1;
        }

        int res = 0;

        while (!pq.isEmpty()) {
            Cell now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] != 1) {
                    visited[nx][ny] = 1;
                    pq.offer(new Cell(nx, ny, Math.max(now.h, heights[nx][ny])));

                    res += Math.max(0, now.h - heights[nx][ny]);
                }
            }
        }

        return res;
    }


class Cell {
    int x;
    int y;
    int h;

    public Cell() {}

    public Cell(int xx, int yy, int hh) {
        x = xx;
        y = yy;
        h = hh;
    }
}

class CellComparator implements Comparator<Cell> {
    public int compare(Cell c1, Cell c2) {
        return c1.h - c2.h;
    }
}




    public static int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null) {
            return 0;
        }

        if (nums.length < 3) {
            return nums.length;
        }

        int prev = 1;
        int curr = 2;

        while (curr < nums.length) {
            if (nums[curr] == nums[prev] && nums[curr] == nums[prev - 1]) {
                curr++;
            } else {
                prev++;
                nums[prev] = nums[curr];
                curr++;
            }
        }

        return prev + 1;
    }



    public static int sqrt(int x) {
        // write your code here
        if (x < 2) {
            return x;
        }

        long start = 1;
        long end = x;

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;

            if (mid * mid <= x) {
                start = mid;
                if ((mid + 1) * (mid + 1) >= x) {
                    break;
                }
            } else {
                end = mid;
            }
        }

        return (int) start;
    }


    public static String minWindow(String source, String target) {
        // write your code
        if (source == null || target == null || source.length() == 0 || target.length() == 0) {
            return "";
        }

        int n = source.length();

        HashSet<Character> hash = new HashSet<>();
        for (int i = 0; i < target.length(); i++) {
            hash.add(target.charAt(i));
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int j = 0;
        String ans = "";
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < n; ++i) {
            while (j < n && map.size() < target.length()) {
                char c = source.charAt(j);
                if (count == target.length()) {
                    break;
                }
                if (hash.contains(c)) {
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    }

                    count++;
                }

                j++;
            }

            if (map.size() == hash.size() && count == target.length() && min > (j - i)) {
                min = j - i;
                ans = source.substring(i, j);
            }

            char cc = source.charAt(i);
            if (hash.contains(cc)) {
                if ( map.get(cc) > 1) {
                    map.put(cc, map.get(cc) - 1);
                } else {
                    map.remove(cc);
                }
                count--;
            }
        }

        return ans;
    }


    public static int longestPalindrome(String s) {
        if (s.length() < 1) {
            return 0;
        }

        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            int currLen = getPalindrome(s, l, r);

            if (currLen > maxLen) {
                maxLen = currLen;
            }
        }
        return maxLen;
    }

    private static int getPalindrome(String s, int l, int r) {
        if (l > r) {
            return 1;
        }

        int n = s.length();
        while (r + 1 < n && s.charAt(r) == s.charAt(r + 1)) {
            r++;
        }

        while (l - 1 >= 0 && r + 1 < n && s.charAt(l - 1) == s.charAt(r + 1)) {
            l--;
            r++;
        }

        return r - l + 1;
    }


    public static int reverseInteger(int n) {
        // Write your code here
        if (n == 0 || n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) {
            return 0;
        }

        int sign = 1;
        if (n < 0) {
            sign = -1;
        }

        n = Math.abs(n);
        long res = 0;

        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;

            if (res > Integer.MAX_VALUE) {
                return 0;
            }
        }

        return (int) res * sign;
    }



    public static int maxCoins(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] newArr = getNewArr(nums);

        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            dp[i][i] = newArr[i - 1] * newArr[i] * newArr[i + 1];
        }

        for (int len = 1; len < n + 1; len++) {
            for (int l = 1; l <= n - len + 1; l++) {
                int r = l + len - 1;
                for (int k = l; k <= r; k++) {
                    int tmp = newArr[l - 1] * newArr[k] * newArr[r + 1];
                    dp[l][r] = Math.max(dp[l][k], dp[l][k - 1] + tmp + dp[k + 1][r]);
                }
            }
        }


        return dp[1][n];
    }

    private static int[] getNewArr(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            if (i == 0 || i == n + 1) {
                newArr[i] = 1;
            } else {
                newArr[i] = nums[i - 1];
            }
        }

        return newArr;
    }

    public static int testfinally() {
        try {
            System.out.println("trye ");
            return 2;
        } catch (Exception x) {

        } finally {
            System.out.println("finally");
            return 4;
        }

    }
    public static void main(String[] args) {
        int[] tt = new int[4];
        Arrays.fill(tt, 1);

        Arrays.stream(tt).forEach(i -> System.out.println(i));

        int[] nums = {4,1,5,10};
//        System.out.println(testfinally());

//        maxCoins(nums);


        Random ran = new Random();


//        reverseInteger(1534236469);

//        int[] nums = {1,1,1,2,2,2,3};

        LinkedList<Integer> list = new LinkedList<>();
        list.offerLast(0);
        list.offerLast(1);
        list.offerLast(2);

        Collections.sort(list);

//        Math.pow(3,2);


//        System.out.println(list.peekFirst());
//        minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd");

//        longestPalindrome("abccccdd");
//        String s = "hello  world from boo bear   ";
//        String[] arr = s.split(" ");
//        System.out.print("ss".charAt(0) - 0);
//
//        int[] arr = {1,2,3,4};
//
//        int[] newarr = Arrays.copyOf(arr, 6);
//        newarr[0] = 1;
    }
}
