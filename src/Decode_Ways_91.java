/**
 * Created by sunbo_000 on 10/5/2016.
 */
public class Decode_Ways_91 {
    public int numDecodings(String s) {

        if (s == null || s.trim().equals("") || s.charAt(0) == '0') return 0;

        int[] result = new int[s.length()];

        result[0] = 1;
        if (s.length() >= 2) {
            if (Integer.valueOf(s.substring(0, 2)) > 26 && s.charAt(1) == '0')
                result[1] = 0;
            else if (Integer.valueOf(s.substring(0, 2)) > 26 || Integer.valueOf(s.substring(0, 2)) == 10 || Integer.valueOf(s.substring(0, 2)) == 20)
                result[1] = 1;
            else result[1] = 2;
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != '0') result[i] = result[i - 1];
            if (s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26)
                result[i] += result[i - 2];
        }

        return result[s.length() - 1];

    }

    public static void main(String[] args) {
        Decode_Ways_91 solution = new Decode_Ways_91();
        System.out.println(solution.numDecodings("27"));
    }
}
