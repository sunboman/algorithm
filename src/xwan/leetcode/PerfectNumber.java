package xwan.leetcode;

/**
 * Created by xwan on 3/25/17.
 */
public class PerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) sum += i;
        }
        return num == sum;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
}
