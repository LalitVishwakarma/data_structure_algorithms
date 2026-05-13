package leetcode.top_interview_questions.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needed = new HashMap();
        Set<Character> neededCharacters = new HashSet();

        for(char c : t.toCharArray()) {
            needed.put(c, needed.getOrDefault(c, 0) + 1);
            neededCharacters.add(c);
        }

        int start = 0;
        int count = Integer.MAX_VALUE;
        String result = "";

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(needed.containsKey(c)) {
                if(needed.get(c) > 1) {
                    needed.put(c, needed.getOrDefault(c, 0) - 1);
                } else {
                    needed.remove(c);
                }


            } else if(needed.isEmpty() && s.charAt(start) == c) {
                start++;
                while(!neededCharacters.contains(s.charAt(start))) {
                    start++;
                }
            }

            if(needed.isEmpty()) {
                if(i - start + 1 < count) {
                    count = i - start + 1;
                    result = s.substring(start, count);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
    }
}
