package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {

    /*
    Input: s = "leetcode", wordDict = ["leet", "code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".
     */

    /*
    Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    Output: false
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] arr = new int[s.length() + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] != -1) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String subString = s.substring(i, j);
                    if (wordDict.contains(subString)) {
                        arr[j] = i;
                    }
                }
            }
        }
        return arr[s.length()] != -1;
    }

    /*
    152. Maximum Product Subarray
    Input: [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.
     */

    public int maxProduct(int[] nums) {

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0];

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }

    /*
    96. Unique Binary Search Trees
    Input: 3
    Output: 5
    Explanation:
    Given n = 3, there are a total of 5 unique BST's:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
     */

    public int numTrees(int n) {
        int[] T = new int[n + 1];
        T[0] = 1;
        T[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                T[i] += T[j] * T[i - j - 1];
            }
        }
        return T[n];
    }

    /*
    Leetcode 647
    Input: "aaa"
    Output: 6
    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     */

    int count = 0;

    public int countSubstrings(String s) {

        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);

            helper(s, i, i + 1);
        }

        return count;

    }
    public void helper(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
