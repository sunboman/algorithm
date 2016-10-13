package leetcode.hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunbo_000 on 10/12/2016.
 */

/*
    https://leetcode.com/problems/happy-number/
 */

public class Happy_number_202 {
    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        while (n != 1) {

            int temp = n;
            int sum = 0;
            while(temp != 0) {
                int mod = temp % 10;
                sum += mod * mod;
                temp = temp / 10;
            }


            if(sumSet.contains(sum)) return false;

            n = sum;

            sumSet.add(sum);
        }

        return true;
    }

    public static void main(String[] args) {
        Happy_number_202 solution = new Happy_number_202();
//        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(3));

    }
}
