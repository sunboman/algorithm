package xwan.leetcode;

/**
 * Created by xwan on 2/24/17.
 */
public class CountAndSay38 {
    public static String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        StringBuilder pre;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            pre = res;
            res = new StringBuilder();
            count = 1;
            say = pre.charAt(0);

            for (int j = 1; j < pre.length(); j++) {
                if (pre.charAt(j) != say) {
                    res.append(count).append(say);
                    count = 1;
                    say = pre.charAt(j);
                } else count++;
            }
            res.append(count).append(say);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(6));
    }
}
