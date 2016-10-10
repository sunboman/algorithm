package leetcode;

/**
 * Created by sunbo_000 on 10/3/2016.
 */
public class Divide_Two_Integer_29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long dividend_pos = Math.abs((long) dividend);
        long divisor_pos = Math.abs((long) divisor);
        int result = 0;
        while (dividend_pos >= divisor_pos) {
            int tmp = 0;
            while (dividend_pos >= (divisor_pos << tmp)) tmp++;
            result += 1 << (tmp - 1);
            dividend_pos -= (divisor_pos << (tmp - 1));
        }

        if ((dividend > 0 && divisor < 0) || (divisor > 0 && dividend < 0)) result = -result;

        return result;
    }

    public static void main(String[] args) {
        Divide_Two_Integer_29 Solution = new Divide_Two_Integer_29();
        Solution.divide(-1,1);
    }
}
