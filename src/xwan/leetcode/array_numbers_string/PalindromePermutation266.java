package xwan.leetcode.array_numbers_string;

/**
 * Created by xwan on 12/31/16.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 *   Given a string, determine if a permutation of the string could form a palindrome.
     For example,
     "code" -> False, "aab" -> True, "carerac" -> True.
     Hint:
     Consider the palindromes of odd vs even length. What difference do you notice?
     Count the frequency of each character.
     If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
     Tags: Hash Table
     Similar Problems: (M) Longest Palindromic Substring, (E) Valid Anagram, (M) Palindrome Permutation II
 */
public class PalindromePermutation266 {
    public static boolean isPalindromePerm(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!hash.containsKey(ch)) {
                hash.put(ch, 0);
            }
            hash.put(ch, hash.get(ch) + 1);
        }
        int countOdd = 0;
        for (int ele : hash.values()) {
            if (ele % 2 != 0) {
                countOdd++;
            }
            if (countOdd > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePerm("aadb")); // false
    }
}
