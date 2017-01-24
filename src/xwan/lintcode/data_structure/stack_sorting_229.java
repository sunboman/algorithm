package xwan.lintcode.data_structure;

import java.util.Comparator;
import java.util.Stack;

/**
 * Created by xwan on 11/30/16.
 */
public class stack_sorting_229 {
    class MyComparator implements Comparator<Integer> {


        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }
    /**
     * @param stack an integer stack
     * @return void
     */
    public static void stackSorting(Stack<Integer> stack) {
        // Write your code here
        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            while (!help.isEmpty()) {
                int top = help.peek();
                if (top < curr) {
                    stack.push(help.pop());
                } else {
                    break;
                }
            }

            help.push(curr);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
