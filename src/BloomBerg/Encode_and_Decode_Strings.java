package BloomBerg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbo on 12/30/2016.
 */
/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is
decoded back to the original list of strings.

Machine 1 (sender) has the function:
string encode(vector<string> strs) { // ... your code return encoded_string; }
Machine 2 (receiver) has the function:
vector<string> decode(string s) { //... your code return strs; }

So Machine 1 does:
string encoded_string = encode(strs);
and Machine 2 does:
vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note: The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized
enough to work on any possible characters. Do not use class member/global/static variables to store states. Your encode and decode
algorithms should be stateless. Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */
public class Encode_and_Decode_Strings {
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if (str == null) {
                sb.append(-1).append('#');
                continue;
            }
            int len = str.length();
            sb.append(len).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>(0);
        }
        List<String> res = new ArrayList<>();
        int left = -1;
        int right = -1;
        int index = 0;
        while (index < s.length()) {
            int temp = index;
            while (s.charAt(index) != '#') {
                index++;
                if (index >= s.length()) {
                    break;
                }
            }
            int len = Integer.valueOf(s.substring(temp, index));
            if (len == 0) {
                res.add("");
                index++;
                continue;
            } else if (len == -1) {
                res.add(null);
                index++;
                continue;
            }
            left = index + 1;
            right = index + len;
            res.add(s.substring(left, right + 1));
            index = right + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(null);
        list.add("");
        String encoded = new Encode_and_Decode_Strings().encode(list);
        List<String> decode = new Encode_and_Decode_Strings().decode(encoded);
        
    }
}
