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
}
