package xwan.cracking.coding.moderate;

/**
 * Created by xwan on 2/9/17.
 */

/**
 * Write a function to swap a number in place (that is, without temporary variables)
 */
public class SwapNumber {
    public static void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + ", " + b);
    }

    // xor, x^0 = x, x^x = 0
    public static void swap_xor(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ", " + b);
    }

    public static void main(String[] args) {
        swap(3,8);
        swap_xor(8, 10);
    }
}
