package xwan.lintcode.array_and_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xwan on 11/29/16.
 */
public class three_3sum_57 {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        if (numbers == null || numbers.length < 3) {
            return results;
        }

        int n = numbers.length;
        Arrays.sort(numbers);

        for (int i = 0; i < n; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = numbers[i] + numbers[l] + numbers[r];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[l]);
                    list.add(numbers[r]);

                    results.add(list);

                    l++;
                    r--;

                    while (l < r && numbers[l] == numbers[l - 1]) {
                        l++;
                    }
                    while (l < r && numbers[r] == numbers[r + 1]) {
                        r--;
                    }
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }

        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        threeSum(nums);

    }
}
