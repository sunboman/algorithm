package xwan.bloomberg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwan on 1/4/17.
 */
public class PermutationSequence60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<String> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(String.valueOf(i));
        }

        int factorial = n - 1;
        for (int i = n - 2; i > 0; i--) {
            factorial *= i;
        }
        if (n == 1) {
            return n + "";
        }
        k--;
        int curr = 0;
        for (int i = 1; i <= n; i++) {
            int idx = k / factorial;
            sb.append(nums.get(idx));
            nums.remove(idx);
            k %= factorial;
            if (i < n) {
                factorial /= n - i;
            } else {
                factorial = 1;
            }
        }
        return sb.toString();
    }
}
