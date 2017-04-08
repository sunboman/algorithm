package xwan.linkedin;

import java.util.*;

/**
 * Created by xwan on 2/18/17.
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, String> treemap = new TreeMap<>();
        treemap.put(2, "a");
        treemap.put(4, "b");
        treemap.put(1, "c");
        treemap.put(3, "d");
        for (Integer i : treemap.keySet()) {
            System.out.println(i + ", " + treemap.get(i));
        }
        Map<Integer, Integer> map = new HashMap<>();
//        System.out.println(map.put(1, 4));
//        System.out.println(map.put(2, 6));

        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
//        hashSet.add(1);
        List<Integer> list = new ArrayList<>();
        new ArrayList<>();
//        System.out.println('0' - 1);
//        System.out.println("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".length());
//        System.out.println(0 >> 1);
        Random random = new Random();
        random.nextInt(4);
    }
}
