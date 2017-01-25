package xwan.amazon;

/**
 * Created by xwan on 1/24/17.
 */

import java.util.*;

/**
 *   给十几个城市供电，连接不同城市的花费不同，让花费最小同时连到所有的边。给出一系列connection类，里面是edge两端的城市名和它们之间的一个cost，找出要你挑一些边，把所有城市连接起来并且总花费最小。不能有环，最后所以城市要连成一个连通块。
     不能的话输出空表，最后还要按城市名字排序输出，按照node1来排序,如果一样的话再排node2。
     输入:
     {"Acity","Bcity",1}
     ("Acity","Ccity",2}
     ("Bcity","Ccity",3}

     输出：
     ("Acity","Bcity",1}
     ("Acity","Ccity",2}
 */
public class CityConnectionLowCost {
    class Connection {
        String node1;
        String node2;
        int cost;

        public Connection(String node1, String node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }
    }

    public static List<Connection> getLowCost(List<Connection> connections) {
        Set<String> nodes = new HashSet<>();
        Map<Integer, List<Connection>> map = new HashMap<>();
        Collections.sort(connections, (conn1, conn2) -> conn1.cost - conn2.cost);
        for (Connection conn : connections) {
            int key = conn.cost;
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<Connection>());
            }
            List<Connection> curr = map.get(key);
            curr.add(conn);
            map.put(key, curr);
            nodes.add(conn.node1);
            nodes.add(conn.node2);
        }

        List<Connection> res = new ArrayList<>();
        int count = nodes.size();
        nodes.clear();
        for (Integer key : map.keySet()) {
            for (Connection conn : map.get(key)) {
                if (nodes.contains(conn.node1) && nodes.contains(conn.node2)) {
                    continue;
                }
                nodes.add(conn.node1);
                nodes.add(conn.node2);
                res.add(conn);
            }
            if (nodes.size() == count) {
                break;
            }
        }
        Collections.sort(res, (conn1, conn2) -> {
            if (!conn1.node1.equals(conn2.node1)) {
                return conn1.node1.compareTo(conn1.node1);
            } else if (!conn1.node2.equals(conn2.node2)){
                return conn1.node2.compareTo(conn2.node2);
            } else {
                return conn1.cost - conn2.cost;
            }
        });
        return res;
    }

    public static void main(String[] args) {
        CityConnectionLowCost cityconn = new CityConnectionLowCost();
        List<Connection> connections = new ArrayList<Connection>();
        connections.add(cityconn.new Connection("A", "B", 2));
        connections.add(cityconn.new Connection("A", "D", 2));
        connections.add(cityconn.new Connection("A", "C", 1));
        connections.add(cityconn.new Connection("D", "B", 4));
        connections.add(cityconn.new Connection("D", "C", 3));
        connections.add(cityconn.new Connection("A", "E", 5));
        connections.add(cityconn.new Connection("D", "E", 3));

        getLowCost(connections);
    }

}
