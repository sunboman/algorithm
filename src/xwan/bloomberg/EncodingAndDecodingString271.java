package xwan.bloomberg;

/**
 * Created by xwan on 1/1/17.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *   Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

     Machine 1 (sender) has the function:

     string encode(vector<string> strs) {
     // ... your code
     return encoded_string;
     }
     Machine 2 (receiver) has the function:

     vector<string> decode(string s) {
     //... your code
     return strs;
     }


     So Machine 1 does:

     string encoded_string = encode(strs);


     and Machine 2 does:

     vector<string> strs2 = decode(encoded_string);


     strs2 in Machine 2 should be the same as strs in Machine 1.

     Implement the encode and decode methods.

     Note:

     The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
     Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
     Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */
public class EncodingAndDecodingString271 {
    // encode
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }

    // decode
    public static List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        while (idx < s.length()) {
            int split = s.indexOf("/", idx);
            int len = Integer.valueOf(s.substring(idx, split));
            res.add(s.substring(split + 1, split + len + 1));
            idx = len + split + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("Do ", "not ", "use ", "class ", "", "member/","global/", "static ", "variables");
        System.out.println(decode(encode(strs)));
    }
}
