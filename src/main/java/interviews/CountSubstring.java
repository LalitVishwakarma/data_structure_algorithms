package interviews;// Java program to CountKSubStr number of substrings
// with exactly distinct characters in a given string
import java.util.Arrays;

public class CountSubstring
{
    // Function to count number of substrings
    // with exactly k unique characters
    int[] countkDist(String str, int k)
    {
        // Initialize result
        int res[] = new int[26];

        int n = str.length();

        // To store count of characters from 'a' to 'z'
        int cnt[] = new int[26];

        // Consider all substrings beginning with
        // str[i]
        for (int i = 0; i < n; i++)
        {
            int dist_count = 0;

            // Initializing count array with 0
            Arrays.fill(cnt, 0);

            // Consider all substrings between str[i..j]
            for (int j=i; j<n; j++)
            {
                // If this is a new character for this
                // substring, increment dist_count.
                if (cnt[str.charAt(j) - 'a'] == 0)
                    dist_count++;

                // Increment count of current character
                cnt[str.charAt(j) - 'a']++;

                // If distinct character count becomes k,
                // then increment result.
//                if (dist_count == k)
//                    res++;
                res[dist_count - 1]++;
            }
        }

        for(int i =0; i < res.length; i++){
            for(int j = i+1; j < res.length; j++){
                res[i] += res[j];
            }
        }

        return res;
    }

    // Driver Program
    public static void main(String[] args)
    {
        CountSubstring ob = new CountSubstring();
        String ch = "abcbaa";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                k +    " distinct characters : "
                + Arrays.toString(ob.countkDist(ch, k)));
    }
}
