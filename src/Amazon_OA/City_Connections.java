package Amazon_OA;//给好的connection class，两个城市名，和一个cost。

import java.util.*;

class Connection {
    String node1;
    String node2;
    int cost;

    public Connection(String a, String b, int c) {
        node1 = a;
        node2 = b;
        cost = c;
    }
}

//下面进入正题
public class City_Connections {
   /* public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
        //还是拿来输出
        ArrayList<Connection> result = new ArrayList<>();
        //这个是用来去重的
        Set<String> set = new HashSet<>();
        //每个string都要有个背后的string,这里用map来记录
        Map<String, String> map = new HashMap<>();
        //Kruskal算法就是先把这几条路排个序
        Collections.sort(connections, (a,b) -> a.cost - b.cost);
        //初始化,把所有出现过的城市都加进去,同时每个城市都以自己为爹,map记录自己
        for (Connection c : connections) {
            String cityA = c.node1;
            String cityB = c.node2;
            set.add(cityA);
            set.add(cityB);
            map.put(cityA, cityA);
            map.put(cityB, cityB);
        }
        //这里其实写的简化了一点儿,对每个排出来的Connection进行检查是否成团
        for (Connection c : connections) {
            //这里把检查成环和连成环写在了一起,有点儿非主流
            //union返回true说明两个点在这次从不同联盟里面联合在了一起
            if (union(c.node1, c.node2, map)) {
                result.add(c);
            }
        }
        //如果点的个数不是比边多一条的话,那说明所有点不在同一个联盟啊
        if ((set.size() - 1) != result.size()) {
            return null; //这里不能输出空的,test case告诉我的。
        }
        Collections.sort(result, (a,b) -> {
            if (a.node1.equals(b.node1)) {
                return a.node2.compareTo(b.node2);
            }
            return a.node1.compareTo(b.node1);
        });
        return result;
    }

    //这里其实可以拆成两个function,一个是判断是否连接,另一个是把这两个点相连
    //因为模板里union返回是void
    private static boolean union(String a, String b, Map<String, String> map) {
        String aRoot = find(a, map);
        String bRoot = find(b, map);
        //这里加了个返回boolean值,就是图省事儿。
        if (aRoot.equals(bRoot)) {
            return false;
        }
        //这里是把两个点联合在了一起。
        map.put(bRoot, aRoot);
        return true;
    }

    private static String find(String a, Map<String, String> map) {
        if (a.equals(map.get(a))) {
            return a;
        }
        //这里还是图省事儿用递归去找,其实迭代写法也很容易
        String parent = find(map.get(a), map);
        //这里多了一步路径压缩,其实没啥用
        map.put(a, map.get(map.get(a)));
        return parent;
    }*/


    private static List<Connection> getLowCost(List<Connection> connections) {
        if (connections == null || connections.size() == 0) {
            return new ArrayList<>(0);
        }
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (Connection connection : connections) {
            set.add(connection.node1);
            set.add(connection.node2);
            map.put(connection.node1, connection.node1);
            map.put(connection.node2, connection.node2);
        }
        Collections.sort(connections, Comparator.comparingInt(o -> o.cost));
        List<Connection> result = new ArrayList<>();
        for (Connection connection : connections) {
            String city1 = connection.node1;
            String city2 = connection.node2;
            if (isConnected(city1, city2, map)) {
                continue;
            }
            union(city1, city2, map);
            result.add(connection);
        }
        if (set.size() - 1 != result.size()) {
            return new ArrayList<>(0);
        }
        Collections.sort(result, (a,b) -> {
            if (a.node1.equals(b.node1)) {
                return a.node2.compareTo(b.node2);
            }
            return a.node1.compareTo(b.node1);
        });
        return result;
    }

    private static void union(String city1, String city2, Map<String, String> map) {
        String root1 = findRoot(city1, map);
        String root2 = findRoot(city2, map);
        map.put(root1, root2);
    }

    private static boolean isConnected(String city1, String city2, Map<String, String> map) {
        String root1 = findRoot(city1, map);
        String root2 = findRoot(city2, map);
        return root1.equals(root2);
    }

    private static String findRoot(String city, Map<String, String> map) {
        while (!map.get(city).equals(city)) {
            map.put(city, map.get(map.get(city)));
            city = map.get(city);
        }
        return city;
    }

    //这里还是测试用的
    public static void main(String[] args) {
        List<Connection> connections = new ArrayList<>();
        //这里还是一个苯环形状，有化学出身的看到这里可以鼓掌了
        connections.add(new Connection("A", "B", 6));
        connections.add(new Connection("B", "C", 4));
        connections.add(new Connection("C", "D", 5));
        connections.add(new Connection("D", "E", 8));
        connections.add(new Connection("E", "F", 1));
        connections.add(new Connection("B", "F", 10));
        connections.add(new Connection("E", "C", 9));
        connections.add(new Connection("F", "C", 7));
        connections.add(new Connection("B", "E", 3));
        connections.add(new Connection("A", "F", 1));

        List<Connection> res = getLowCost(connections);
        for (Connection c : res) {
            System.out.println(c.node1 + " -> " + c.node2 + " 需要花费大洋 : " + c.cost);
        }
    }
}