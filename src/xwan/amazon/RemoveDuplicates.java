package xwan.amazon;

/**
 * Created by xwan on 1/18/17.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        String a1 = "a";
        a1 += "bb";
        String a2 = a1 + 'b';
        String a3 = "a" + "b";
        System.out.println(a2 == "ab");
        System.out.println(a3 == "ab");
        System.out.println(a1);
    }
}
