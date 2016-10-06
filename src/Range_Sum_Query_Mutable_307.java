import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbo_000 on 10/5/2016.
 */
public class Range_Sum_Query_Mutable_307 {
    static class NumArray {

        private int[] bitTree = null;
        private int[] m_nums = null;

        public NumArray(int[] nums) {
            m_nums = nums;
            bitTree = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                int j = i & -i;
                while (j > 0) {
                    bitTree[i] += nums[i - j];
                    j--;
                }
            }

        }

        int add(int k) {
            int sum = 0;
            while (k > 0) {
                sum += bitTree[k];
                k -= k & -k;
            }
            return sum;
        }

        void update(int i, int val) {
            int k = i + 1;
            int gap = val - m_nums[i];
            while (k < bitTree.length) {
                bitTree[k] += gap;
                k += k & -k;
            }
            m_nums[i] = val;
        }

        public int sumRange(int i, int j) {
            return add(j + 1) - add(i);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 2, 7, 2, 0};
        NumArray solution = new NumArray(array);
        List<Integer> resultList = new ArrayList<>();
        solution.update(4, 6);
        solution.update(0, 2);
        solution.update(0, 9);
        resultList.add(solution.sumRange(4, 4));
        solution.update(3, 8);
        resultList.add(solution.sumRange(0, 4));
        solution.update(4, 1);
        resultList.add(solution.sumRange(0, 3));
        resultList.add(solution.sumRange(0, 4));
        solution.update(0, 4);
        for (Integer i : resultList) {
            System.out.print(i + ",");
        }
    }


}
