package xwan.bloomberg;

/**
 * Created by xwan on 1/1/17.
 */

/**
 * There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds around the circle in a fixed direction.
 * In each step, a certain number of people are skipped and the next person is executed.
 * The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed),
 * until only the last person remains, who is given freedom.
 * Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle.
 * The task is to choose the place in the initial circle so that you are the last one remaining and so survive.
 *
 *
 * For example, if n = 5 and k = 2, then the safe position is 3.
 * Firstly, the person at position 2 is killed, then person at position 4 is killed, then person at position 1 is killed.
 * Finally, the person at position 5 is killed. So the person at position 3 survives.
 *
 * If n = 7 and k = 3, then the safe position is 4. The persons at positions 3, 6, 2, 7, 5, 1 are killed in order, and person at position 4 survives.
 */
public class Josephus {
    public static int josephus_recur(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (josephus_recur(n - 1, k) + (k - 1)) % n + 1;
    }

    public static int josephus_ite(int n, int k) {
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int idx = 0;
        int killIdx = 1;
        int left = n;
        while (left > 1) {
            if (nums[idx % n] > 0) {
                if (killIdx == k) {
                    nums[idx % n] = -1;
                    idx++;
                    killIdx = 1;
                    left--;
                } else {
                    idx++;
                    killIdx++;
                }
            } else {
                idx++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(josephus_recur(15, 4));
        System.out.println(josephus_ite(15, 4));
    }
}
