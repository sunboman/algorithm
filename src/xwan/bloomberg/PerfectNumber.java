package xwan.bloomberg;

/**
 * Created by xwan on 1/30/17.
 */

/**
 * A natural number n is perfect, if it's value is equal to a sum of all his positive divisors (excluding number n itself).
 * The first perfect numbers are 6, 28, 496, 8128 and all of them are in form 2^{n-1} \\cdot (2^{n}-1).
 * Greek mathematician Euclid proved that the formula is en even perfect number whenever 2^{p-1} is a prime.
 *
 * Example
 *
 * 6 = 3 + 2 + 1
 * 28 = 14 + 7 + 4 + 2 + 1
 * 496 = 248 + 124 + 62 + 31 + 16 + 8 + 4 + 2 + 1
 * 8128 = 4064 + 2032 + 1016 + 508 + 254 + 127 + 64 + 32 + 16 + 8 + 4 + 2 + 1
 *
 */
public class PerfectNumber {
    public static boolean isPerfectNum(long num) {
        if (num % 2 == 1) {
            return false;
        }
        long result = 1;
        long i = 2;
        while (i * i <= num) {
            if (num % i == 0) {
                result += i;
                result += num / i;
            }
            i++;
        }

        // when perfect square, it added twice i, should reduce one i
        if (i * i == num) {
            result -= i;
        }
        return result == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectNum(6));
        System.out.println(isPerfectNum(28));
        System.out.println(isPerfectNum(209));
        System.out.println(isPerfectNum(496));
    }

}
