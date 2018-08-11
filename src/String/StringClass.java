package String;

import java.lang.String;

public class StringClass {

    /*
    Leetcode 696
    Input: "00110011"
    Output: 6
    Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

    Notice that some of these substrings repeat and are counted the number of times they occur.

    Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
     */

    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        int pre = 0;
        int cur = 1;

        int total = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }

            if (pre >= cur) total++;
        }

        return total;
    }

    /*
    Leetcode 67.
    Input: a = "11", b = "1"
    Output: "100"
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();

    }

    /*
    165. Compare Version Numbers
    Input: version1 = "1.0.1", version2 = "1"
    Output: 1

    Input: version1 = "7.5.2.4", version2 = "7.5.3"
    Output: -1
     */

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int loop = Math.max(arr1.length, arr2.length);

        for (int i = 0; i < loop; i++) {
            Integer x1 = i < arr1.length ? Integer.parseInt(arr1[i]) : 0;
            Integer x2 = i < arr2.length ? Integer.parseInt(arr2[i]) : 0;

            int compared = x1.compareTo(x2);

            System.out.println(x1 + " " + x2 + " Compared: " + compared);

            if (compared != 0)
                return compared;
        }

        return 0;
    }

}
