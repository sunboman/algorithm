package leetcode;

/**
 * Created by sunbo_000 on 10/3/2016.
 */
public class Count_Bits_338 {
    /*
        if a num is the integer power of 2, the number of 1 is 1, or it is the previous one add one
     */
    int[] countBits(int num) {

        int[] result = new int[num + 1];

        int power2 = 1;
        int prev = 1;

        for (int i = 1; i <= num; i++) {
            if (i == power2) {
                result[i] = prev = 1;
                power2 <<= 1;
            } else {
                result[i] = result[prev] + 1;
                prev++;
            }
        }

        return result;
    }

    /*
        a number multiply by 2 meas the number left shift a bit, which means the number of 1 is the same or add one if it
        cannot divide by 2
     */
    int[] countBits2(int num) {

        int[] result = new int[num + 1];

        for(int i=1;i<=num;i++) {
            result[i] = result[i >> 1] + (i&1);
        }

        return result;
    }

    public static void main(String[] args) {
        Count_Bits_338 Solution = new Count_Bits_338();
        Solution.countBits(5);
        Solution.countBits2(8);
    }
}
