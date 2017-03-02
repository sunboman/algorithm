package xwan.leetcode;


import java.util.*;

/**
 * Created by xwan on 2/25/17.
 */
public class InsertDelRandomed {
    List<Integer> nums;
    Map<Integer, Integer> map;
    Random random;

    /** Initialize your data structure here. */
    public InsertDelRandomed() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int pos = map.get(val);
        if (pos < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(pos, last);
            map.put(last, pos);
        }
        nums.remove(nums.size() - 1);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        InsertDelRandomed inrd = new InsertDelRandomed();
        System.out.println(inrd.insert(1));
        System.out.println(inrd.remove(2));
        System.out.println(inrd.insert(2));
        System.out.println(inrd.getRandom());
        System.out.println(inrd.remove(1));
        System.out.println(inrd.insert(2));
        System.out.println(inrd.getRandom());
    }
}
