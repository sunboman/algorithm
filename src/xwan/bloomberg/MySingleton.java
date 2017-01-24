package xwan.bloomberg;

/**
 * Created by xwan on 1/2/17.
 */
public class MySingleton {
    // thread safe singleton
//    private static final MySingleton instance = new MySingleton();
//    private MySingleton() {}
//
//    public static MySingleton getInstance() {
//        return instance;
//    }


    // 2.
    private static MySingleton instance = null;
    private MySingleton() {}
    public static MySingleton getInstance() {
        synchronized (MySingleton.class) {
            if (instance == null) {
                instance = new MySingleton();
            }
        }
        return instance;
    }
}
