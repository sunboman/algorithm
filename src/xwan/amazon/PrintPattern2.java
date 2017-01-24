package xwan.amazon;

/**
 * Created by xwan on 1/18/17.
 */

/**
 * a
 * ab
 * abc
 * abcd
 */
public class PrintPattern2 {
    public static void print2(int row) {
        for (int i = 1; i <= row; i++) {
            char ch = 'a';
            char print = ch;
            for (int j = 0; j < i; j++) {
                System.out.print((print++));
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        print2(5);
    }
}
