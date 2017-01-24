package xwan.bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xwan on 1/1/17.
 */
public class TopKFrequentElements347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int max = 0;
        for (int frq : map.values()) {
            max = Math.max(max, frq);
        }
        ArrayList<Integer>[] buckets = (ArrayList<Integer>[]) new ArrayList[max + 1];
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            int frq = en.getValue();
            int num = en.getKey();
            if (buckets[frq] == null) {
                buckets[frq] = new ArrayList<>();
            }
            buckets[frq].add(num);
        }
        for (int i = max; i >= 0; i--) {
            if (buckets[i] != null) {
                res.addAll(buckets[i]);
            }
            if (res.size() == k) {
                break;
            }
        }
        return res;
    }
}
