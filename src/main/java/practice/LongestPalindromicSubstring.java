package practice;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        // DP table to store palindrome status
        boolean[][] dp = new boolean[n][n];

        int start = 0;      // Start index of the longest palindromic substring
        int maxLength = 1;  // Length of the longest palindromic substring

        // All substrings with a single character are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for 2-character palindromes
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Fill the DP table for substrings longer than 2 characters
        for (int length = 3; length <= n; length++) { // length is the substring length
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1; // Ending index of the substring

                // Check if s[i:j+1] is a palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = length;
                }
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babab")); // Output: "bab" or "aba"
        System.out.println(longestPalindrome("cbbd"));  // Output: "bb"
    }
}
