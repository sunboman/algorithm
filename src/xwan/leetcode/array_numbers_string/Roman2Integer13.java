package xwan.leetcode.array_numbers_string;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * Created by xwan on 12/29/16.
 */
public class Roman2Integer13 {
    public static int romanToInt(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        ans = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                ans += map.get(s.charAt(i));
            } else {
                ans -= map.get(s.charAt(i));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("DCXXI")); // 621
    }
}
