package leetcode.recursion;

/**
 * Created by sunbo_000 on 10/13/2016.
 */
public class Pow_50 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;

        double half = myPow(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        else
            return half * half * myPow(x, n % 2);
    }

    public static void main(String[] args) {
        Pow_50 solution = new Pow_50();
        System.out.println(solution.myPow(-2.0, -3));
    }
}
