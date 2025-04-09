package Challange500;

import org.apache.commons.lang3.tuple.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Approach: Optimized Sliding Window
 * Intuition
 * The question asks us to return the minimum window from the string S which has all the characters of the string T.
 * Let us call a window desirable if it has all the characters from T.
 * We can use a simple sliding window approach to solve this problem.
 * In any sliding window based problem we have two pointers. One right pointer whose job is to expand the current window
 * and then we have the left pointer whose job is to contract a given window. At any point in time only one of these
 * pointers move and the other one remains fixed.
 * The solution is pretty intuitive. We keep expanding the window by moving the right pointer. When the window has all
 * the desired characters, we contract (if possible) and save the smallest window till now.
 *
 * A small improvement to the above approach can reduce the time complexity of the algorithm to O(2∗∣filtered_S∣+∣S∣+∣T∣),
 * where filtered_S is the string formed from S by removing all the elements not present in T.
 * This complexity reduction is evident when ∣filtered_S∣<<<∣S∣.
 * This kind of scenario might happen when length of string T is way too small than the
 * length of string S and string S consists of numerous characters which are not present in T.
 * */

public class MinimumWindowSubstring {
    public String minWindow(String s, String r) {
        if (s.isEmpty() || r.isEmpty())
            return "";
        Map<Character, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < r.length(); i++) {
            int value = dictionary.getOrDefault(r.charAt(i), 0);
            dictionary.put(r.charAt(i), value + 1);
        }

        int required = dictionary.size();

        Map<Character, Integer> winCount = new HashMap<>();

        int present = 0;

        int left = 0, right = 0;
        int[] result = {-1, 0, 0};
        List<Pair<Integer, Character>> charIndexes = new ArrayList();

        for (int i = 0; i < s.length(); i++) {
            if (dictionary.containsKey(s.charAt(i))) {
                charIndexes.add(Pair.of(i, s.charAt(i)));
            }
        }
        while (right < charIndexes.size()) {
            char c = charIndexes.get(right).getValue();
            int value = winCount.getOrDefault(c, 0);
            winCount.put(c, value + 1);

            if (dictionary.containsKey(c) && dictionary.get(c) == winCount.get(c))
                present++;

            while (left < right && present == required) {

                int end = charIndexes.get(right).getKey();
                int start = charIndexes.get(left).getKey();
                if (result[0] == -1 || end - start + 1 < result[0]) {
                    result[0] = end - start + 1;
                    result[1] = start;
                    result[2] = end;
                }

                c = charIndexes.get(left).getRight();
                value = winCount.get(c);
                winCount.put(c, value - 1);

                if (dictionary.containsKey(c) && dictionary.get(c) > winCount.get(c))
                    present--;

                left++;
            }
            right++;
        }
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }


    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ABAACBAB", "ABC"));
    }
}
