package Basic;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSubstrings {
    public void addPalindrome(String s, int left, int right, List<String> result) {
        while(left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result.add(s.substring(left, right+1));
            left--;
            right++;
        }
    }
    public List<String> publicSubstring(String s) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            addPalindrome(s, i, i, result);
            addPalindrome(s, i, i+1, result);
        }
        return result;
    }

    public static void main(String[] args) {
        PalindromeSubstrings palindromeSubstrings = new PalindromeSubstrings();
        palindromeSubstrings.publicSubstring("abba").forEach(System.out::println);
    }
}
