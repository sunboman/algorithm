package xwan.linkedin;

/**
 * Created by xwan on 2/14/17.
 */

/**
 * 170. Two Sum III - Data structure design
 *
 * Design and implement a TwoSum class. It should support the following operations: add and find.

     add - Add the number to an internal data structure.
     find - Find if there exists any pair of numbers which sum is equal to the value.

     For example,
     add(1); add(3); add(5);
     find(4) -> true
     find(7) -> false


 */


import java.util.HashMap;
import java.util.Map;

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
public class TwoSumIII {
    private Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSumIII() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, 2);
        } else {
            map.put(number, 1);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num1 = entry.getKey();
            int count = entry.getValue();
            int num2 = value - num1;
            if (num1 == num2 && count == 2 || num1 != num2 && map.get(num2) != null) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSumIII ts = new TwoSumIII();
        ts.add(1);
        ts.add(3);
        ts.add(5);
        System.out.println(ts.find(4));
        System.out.println(ts.find(7));
    }
}
