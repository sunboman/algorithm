package lintcode.binary_search;

/**
 * Created by sunbo_000 on 10/24/2016.
 */

/*
    http://www.lintcode.com/en/problem/first-bad-version/
    The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case,
    so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.

    You can call isBadVersion to help you determine which version is the first bad one. The details interface can be
    found in the code's annotation part.

     Notice

    Please read the annotation in code area to get the correct way to call isBadVersion in different language.
    For example, Java is SVNRepo.isBadVersion(v)
 */

public class First_Bad_Version {

    /**
     * public class SVNRepo {
     * public static boolean isBadVersion(int k);
     * }
     * you can use SVNRepo.isBadVersion(k) to judge whether
     * the kth code version is bad or not.
     */
    private static class SVNRepo {
        public static boolean isBadVersion(int k) {
            return true;
        }
    }


    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int low = 1;
        int high = n;
        while (low + 1 < high) {
            int mid = (low + high) >>> 1;
            if (SVNRepo.isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if (SVNRepo.isBadVersion(low)) {
            return low;
        }

        return high;

    }
}
