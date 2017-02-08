package xwan.cracking.coding;

/**
 * Created by xwan on 2/3/17.
 */

/**
 * Implement an algorithm to determin if a string has all unique characters. no extra data structure
 *
 * question to ask:
 * 1. if String is ASCII string or Unicode String
 */
public class UniqueCharacters {
    public static boolean isUniqueCharacters(String s) {
        if (s.length() > 256) {
            return false;
        }
        boolean[] map = new boolean[256];
        for (char ch : s.toCharArray()) {
            if (map[ch]) {
                return false;
            }
            map[ch] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueCharacters("abs,ydA"));
    }
}
