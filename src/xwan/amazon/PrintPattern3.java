package xwan.amazon;

/**
 * Created by xwan on 1/18/17.
 */

/**
 * 11
 * 1111
 * 111111
 */
public class PrintPattern3 {
    public static void print3(int row) {
        int x = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(x + "" + x);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print3(3);
    }
}
