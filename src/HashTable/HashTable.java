package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTable {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        if (s.length() == 0) return 0;

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

    //500. Keyboard Row

    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                map.put(c, i);
            }
        }
        List<String> answer = new ArrayList<String>();

        for(String s : words)
        {
            int index = map.get(s.toUpperCase().charAt(0));
            for(char c: s.toUpperCase().toCharArray())
            {
                if(map.get(c)!=index)
                {
                    index = -1;
                    break;
                }
            }
            if(index!=-1)
                answer.add(s);
        }

        return answer.toArray(new String[0]);
    }


}
