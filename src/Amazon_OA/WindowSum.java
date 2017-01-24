package Amazon_OA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbo on 11/28/2016.
 */
public class WindowSum {
    public List<Integer> GetSum(List<Integer> A, int k) {
        if (A == null || A.size() < k) {
            return new ArrayList<>(0);
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += A.get(i);
        }
        List<Integer> result = new ArrayList<>(A.size() - k);
        result.add(sum);
        int left = 0;
        for (int right = k; right < A.size(); right++) {
            sum = sum - A.get(left++) + A.get(right);
            result.add(sum);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            A.add(i);
        }
        new WindowSum().GetSum(A, 3);
    }
}
