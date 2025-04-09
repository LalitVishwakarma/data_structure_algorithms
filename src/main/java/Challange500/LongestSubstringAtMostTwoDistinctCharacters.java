package Challange500;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostTwoDistinctCharacters {

    public int longestString(String s) {
        int n = s.length();
        if(n < 3)
            return n;
        Map<Character, Integer> map = new HashMap();
        int result = 2;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
            if(map.size() > 2) {
                int index = Collections.min(map.values());
                map.remove(s.charAt(index));
                start = index + 1;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringAtMostTwoDistinctCharacters longestSubstringAtMostTwoDistinctCharacters = new LongestSubstringAtMostTwoDistinctCharacters();
        System.out.println(longestSubstringAtMostTwoDistinctCharacters.longestString("ccaabbb"));
        System.out.println(longestSubstringAtMostTwoDistinctCharacters.longestString("eceba"));
    }

}
