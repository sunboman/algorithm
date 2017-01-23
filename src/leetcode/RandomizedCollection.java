package leetcode;

import java.util.*;

public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> set;
        if (map.containsKey(val)) {
            set = map.get(val);
            set.add(list.size() - 1);
            return false;
        } else {
            set = new LinkedHashSet<>();
            set.add(list.size() - 1);
            map.put(val, set);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Set<Integer> set = map.get(val);
            Integer index = set.iterator().next();
            set.remove(index);
            if (set.isEmpty()) {
                map.remove(val);
            }
            if (index < list.size() - 1) {
                Set<Integer> lastSet = map.get(list.get(list.size() - 1));
                list.set(index, list.get(list.size() - 1));
                lastSet.remove(list.size() - 1);
                lastSet.add(index);
            }
            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }
    }
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }

}