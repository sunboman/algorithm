package leetcode.greedy;

/**
 * Created by sunbo_000 on 10/20/2016.
 */

/*
    https://leetcode.com/problems/candy/
    There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    What is the minimum candies you must give?
 */

public class Candy_135 {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) return 1;

        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
            else candies[i] = 1;

        }

        int candy = candies[candies.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            int curr = 1;
            if (ratings[i] > ratings[i + 1]) {
                curr = candies[i + 1] + 1;
            }

            //increasing result is always correct
            candy += Math.max(curr, candies[i]);
            candies[i] = curr;
        }


        return candy;
    }

    public static void main(String[] args) {
//        System.out.println(new Candy_135().candy(new int[]{1, 2, 2}));
        System.out.println(new Candy_135().candy(new int[]{4, 2, 3, 4, 1}));
//        System.out.println(new Candy_135().candy(new int[]{1, 2, 2}));
    }
}
