package xwan.cracking.coding;

/**
 * Created by xwan on 2/3/17.
 */

import java.util.Arrays;

/**
 * given two strings, write a method to decide if one is a permutation of the other
 *
 * question to ask:
 * 1. is case sensitive
 * 2. if whitespace is significant
 */
public class IsPermutation {
    // sort then compare
    public static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    // 2. compare words one by one
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[256];
        for (char ch : s.toCharArray()) {
            letters[ch]++;
        }
        for (char ch : t.toCharArray()) {
            if (--letters[ch] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("adv", "scd"));
        System.out.println(permutation("adv", "adv"));
    }
}
