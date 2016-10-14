package leetcode.dp;

/**
 * Created by sunbo_000 on 10/13/2016.
 */

/*
    https://leetcode.com/problems/count-primes/
 */
public class Count_Primes_204 {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) isPrime[i] = true;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2; j * i < n; j++) {
                    isPrime[j * i] = false;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;

    }


    public static void main(String[] args) {
        Count_Primes_204 solution = new Count_Primes_204();
        System.out.println(solution.countPrimes(10));
    }
}
