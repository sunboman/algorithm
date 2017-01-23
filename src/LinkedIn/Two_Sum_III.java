package LinkedIn;


import java.util.*;

/**
 * Created by sunbo on 12/30/2016.
 */
/*
Design and implement a TwoSum class. It should support the following operations:add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
 */
public class Two_Sum_III {
    Map<Integer, Integer> map;

    public Two_Sum_III() {
        map = new HashMap<>();
    }

    public void add(int i) {
        if (map.containsKey(i)) {
            map.put(i, map.get(i) + 1);
        } else {
            map.put(i, 1);
        }
    }

    public boolean find(int t) {
        if (map == null || map.size() == 0) {
            return false;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int gap = t - value;
            if (gap == value) {
                return entry.getValue() >= 2;
            } else {
                if (map.get(gap) != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
