package leetcode.top_interview_questions.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.isEmpty() || k == 0)
            return 0;
        Map<Character, Integer> map = new HashMap();

        int distinct = 0;
        int start = 0;
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c) && distinct < k) {
                distinct++;
            } else if(!map.containsKey(c)) {
                while(map.get(s.charAt(start)) != start) {
                    start++;
                }
                map.remove(s.charAt(start));
                start++;
            }
            map.put(c, i);
            maxLength = Math.max(maxLength, i - start + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters obj = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(obj.lengthOfLongestSubstringKDistinct("a", 0));
    }
}
