package xwan.lintcode.array_and_numbers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by xwan on 11/29/16.
 */
public class four_4sum_58 {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (numbers == null || numbers.length < 4) {
            return results;
        }

        int n = numbers.length;
        Arrays.sort(numbers);

        for (int i = 0; i < n; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }

                int l = j + 1;
                int r = n - 1;

                while (l < r) {
                    int sum = numbers[i] + numbers[j] + numbers[l] + numbers[r];
                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
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
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        fourSum(nums, 4);
    }
}
