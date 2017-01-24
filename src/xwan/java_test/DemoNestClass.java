package xwan.java_test;

/**
 * Created by xwan on 12/19/16.
 */
public class DemoNestClass {
    private static int cc;
    class InnerClass {
        private int aa;
        void inner() {

        }
    }

    void show() {
        InnerClass in = new InnerClass();
        int a = in.aa;
    }
}
