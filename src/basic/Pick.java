package basic;

import java.util.Collection;


/**
 * Created by sunbo_000 on 7/17/2016.
 */
public class Pick {
    public Integer getSecondLargestInteger(Collection<Integer> integers) {
        if (integers == null || integers.size() < 2) return null;
        Integer secondLargest = Integer.MIN_VALUE;
        Integer largest = Integer.MIN_VALUE;
        for (Integer ele : integers) {
            if (ele > largest) {
                if(largest > secondLargest) secondLargest = largest;
                largest = ele;
                continue;
            }
            if (ele.equals(largest)) {
                secondLargest = ele;
                continue;
            }
            if (ele < largest && ele > secondLargest) secondLargest = ele;
        }
        return secondLargest;
    }

}
