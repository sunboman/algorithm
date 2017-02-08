package xwan.audible;

/**
 * Created by xwan on 2/3/17.
 */

/**
 * Compare two version numbers version1 and version2.
     If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

     You may assume that the version strings are non-empty and contain only digits and the . character.
     The . character does not represent a decimal point and is used to separate number sequences.
     For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

     Here is an example of version numbers ordering:

     0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumber {
    public static int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int i = 0;
        int j = 0;
        while (i < len1 || j < len2) {
            int tmp1 = 0;
            int tmp2 = 0;
            while (i < len1 && version1.charAt(i) != '.') {
                tmp1 = tmp1 * 10 + (version1.charAt(i++) - '0');
            }
            while (j < len2 && version2.charAt(j) != '.') {
                tmp2 = tmp2 * 10 + (version2.charAt(j++) - '0');
            }

            if (tmp1 < tmp2) {
                return -1;
            } else if (tmp1 > tmp2) {
                return 1;
            } else {
                i++;
                j++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("01", "1.0"));
    }
}
