import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunbo_000 on 10/4/2016.
 */
public class Fraction_to_Recurring_Decimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator == 0) return "0";
        if(denominator == 0) return "";

        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        long numeratorLong = Math.abs((long)numerator);
        long denominatorLong = Math.abs((long)denominator);

        long res = numeratorLong / denominatorLong;
        sb.append(res);
        if (numeratorLong % denominatorLong == 0) return sb.toString();
        sb.append(".");
        long remainder = (numeratorLong % denominatorLong) * 10;
        Map<Long, Integer> remainderMap = new HashMap<>();
        while (remainder != 0) {

            if (remainderMap.containsKey(remainder)) {
                sb.insert(remainderMap.get(remainder), "(");
                sb.append(")");
                return sb.toString();
            }

            remainderMap.put(remainder, sb.length());
            sb.append(remainder/denominatorLong);
            remainder = (remainder % denominatorLong) * 10;

        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Fraction_to_Recurring_Decimal_166 solution = new Fraction_to_Recurring_Decimal_166();
        solution.fractionToDecimal(-1,-2147483648);
    }

}
