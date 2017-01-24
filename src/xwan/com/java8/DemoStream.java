package xwan.com.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xwan on 12/19/16.
 */
public class DemoStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        int res = list.stream().map(i -> i * 2).reduce(0, (pre, curr) -> pre + curr);
        System.out.println(res);
    }
}
