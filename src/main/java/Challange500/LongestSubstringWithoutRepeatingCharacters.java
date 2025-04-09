package Challange500;

import java.util.HashMap;
import java.util.Map;
/**
 * Sliding Window Optimized
 * Intuition
 * The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps.
 * Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index.
 * Then we can skip the characters immediately when we found a repeated character.
 *
 * Algorithm
 * The reason is that if s[j] have a duplicate in the range [i,j) with index j
 * ′
 *  , we don't need to increase i little by little. We can skip all the elements in the range [i,j
 * ′
 *  ] and let i to be j
 * ′
 *  +1 directly.
 * */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i)) + 1, start);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - start + 1);

        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters o = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(o.lengthOfLongestSubstring("abcabcbb"));
    }
}
