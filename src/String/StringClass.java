package String;

import java.lang.String;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    /*
    709.
    Input: "Hello"
    Output: "hello"
     */

    public String toLowerCase(String str) {

        char[] a = str.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        }

        return new String(a);

    }


    /*
    804.
    Input: words = ["gin", "zen", "gig", "msg"]
    Output: 2
    Explanation:
    The transformation of each word is:
    "gin" -> "--...-."
    "zen" -> "--...-."
    "gig" -> "--...--."
    "msg" -> "--...--."

    There are 2 different transformations, "--...-." and "--...--.".
     */

    String[] dictionary = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> hashSet = new HashSet<>();
        for (String w : words) {
            hashSet.add(getCode(w));
        }

        return hashSet.size();
    }

    private String getCode(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(dictionary[c - 'a']);
        }

        return sb.toString();
    }


    /*
    657.
    Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

    The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
    Input: "UD"
    Output: true
     */

    public boolean judgeCircle(String moves) {
        //left = (0,-1)
        //right= (0,1)
        //up=(-1,0)
        //down(1,0)
        int row = 0;
        int col = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    row--;
                    break;
                case 'D':
                    row++;
                    break;
                case 'L':
                    col--;
                    break;
                case 'R':
                    col++;
                    break;
            }
        }
        if (row == 0 && col == 0)
            return true;
        return false;

    }

    /*
    Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
    Input: "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"
     */

    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(reverseString(str) + " ");
        }

        return sb.toString().trim();

    }

    private String reverseString(String s) {
        char[] cArray = s.toCharArray();
        int start = 0;
        int end = cArray.length - 1;

        while (start <= end) {
            char temp = cArray[start];
            cArray[start] = cArray[end];
            cArray[end] = temp;

            start++;
            end--;
        }

        return new String(cArray);
    }

    /*
    A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

    We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

    The rules of Goat Latin are as follows:

    If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
    For example, the word 'apple' becomes 'applema'.

    If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
    For example, the word "goat" becomes "oatgma".

    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
    Return the final sentence representing the conversion from S to Goat Latin.

    Input: "I speak Goat Latin"
    Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
     */

    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String toGoatLatin(String S) {
        String[] strArray = S.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strArray.length; i++) {
            sb.append(conversion(strArray[i], i + 1) + " ");
        }
        return sb.toString().trim();

    }

    private String conversion(String s, int index) {
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        if (vowels.contains(charArr[0])) {
            sb.append("ma");
        } else {
            char first = charArr[0];
            sb.deleteCharAt(0);
            sb.append(String.valueOf(first));
            sb.append("ma");
        }

        for (int i = 0; i < index; i++) {
            sb.append("a");
        }

        return sb.toString();

    }



}
