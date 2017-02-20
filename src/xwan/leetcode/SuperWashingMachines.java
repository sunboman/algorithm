package xwan.leetcode;

/**
 * Created by xwan on 2/19/17.
 */
public class SuperWashingMachines {
    public static int findMinMoves(int[] machines) {
        int sum = 0;
        int n = machines.length;
        for (int num : machines) sum += num;
        if (sum == 0) return 0;
        if (sum % n != 0) return -1;
        int target = sum / n;
        int res = 0;

        int[] moves = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int diff = machines[i] - target;
            if (diff > 0) {
                moves[i] += diff;
                machines[i + 1] += diff;
                machines[i] = target;
                res = Math.max(res, moves[i]);
            } else {
                moves[i + 1] = -diff;
                machines[i + 1] += diff;
                machines[i] = target;
                res = Math.max(res, moves[i + 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0 , 5};
        findMinMoves(nums);
    }
}
