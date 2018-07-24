import java.util.HashMap;

public class HashTable {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        HashMap<Character, Integer> set = new HashMap<Character, Integer>();

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.containsKey(s.charAt(i))) {
                j = Math.max(j, set.get(s.charAt(i)) + 1);
            }
            set.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

}
