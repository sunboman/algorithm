package xwan.lintcode.array_and_numbers;

/**
 * Created by xwan on 11/29/16.
 */
public class sort_colors_ii_143 {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public static void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length <= 1) {
            return;
        }

        int start = 0;
        int count = 0;
        int end = colors.length - 1;

        while (count < k) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = start; i <= end; i++) {
                min = Math.min(min, colors[i]);
                max = Math.max(max, colors[i]);
            }

            int l = start;
            int r = end;
            int curr = l;

            while (curr <= r) {
                if (colors[curr] == min) {
                    swap(colors, l, curr);
                    l++;
                    curr++;
                } else if (colors[curr] == max) {
                    swap(colors, curr, r);
                    r--;
                } else {
                    curr++;
                }
            }

            start = l;
            end = r;
            count += 2;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] colors = {1,2,3,3,3,3,3,3};
        int k = 3;

        sortColors2(colors, k);
    }
}
