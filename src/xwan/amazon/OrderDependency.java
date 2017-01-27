package xwan.amazon;

/**
 * Created by xwan on 1/26/17.
 */


import java.util.*;

/**
 * 输入的是一群OrderDependency的object，每个OrderDependency里面装着两个Order，就是一个指向另一个，输出是Order的List
 * refer to Leetcode #210
 */



public class OrderDependency {
    class Order {
        String orderName;

        public Order(String orderName) {
            this.orderName = orderName;
        }
    }
    class OrderDepend {
        Order pre;
        Order curr;

        public OrderDepend(Order pre, Order curr) {
            this.pre = pre;
            this.curr = curr;
        }
    }

    public List<Order> getOrder(List<OrderDepend> orderDependList) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> countPre = new HashMap<>();
        Set<String> hash = new HashSet<>();
        for (OrderDepend depend : orderDependList) {
            Order pre = depend.pre;
            Order curr = depend.curr;
            String preName = pre.orderName;
            String currName = curr.orderName;

            hash.add(preName);
            hash.add(currName);

            if (!countPre.containsKey(preName)) {
                countPre.put(preName, 0);
            }
            if (countPre.containsKey(currName)) {
                countPre.put(currName, countPre.get(currName) + 1);
            } else {
                countPre.put(currName, 1);
            }

            if (!map.containsKey(preName)) {
                map.put(currName, new ArrayList<String>());
            }
            List<String> tmp = map.get(preName);
            tmp.add(currName);
            map.put(preName, tmp);
        }

        List<Order> res = new ArrayList<>();
        Queue<Order> queue = new LinkedList<>();
        for (String name : countPre.keySet()) {
            if (countPre.get(name) == 0) {
                queue.add(new Order(name));
            }
        }

        while (!queue.isEmpty()) {
            Order top = queue.poll();
            res.add(top);
            String topName = top.orderName;
            for (String next : map.get(topName)) {
                countPre.put(next, countPre.get(next) - 1);
                if (countPre.get(next) == 0) {
                    queue.add(new Order(next));
                }
            }
        }

        if (res.size() != hash.size()) {
            return null;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
