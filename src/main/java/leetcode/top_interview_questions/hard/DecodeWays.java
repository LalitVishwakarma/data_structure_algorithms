package leetcode.top_interview_questions.hard;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    int count = 0;

    public boolean isValid(String s) {
        System.out.println(s);
        int n = Integer.parseInt(s);
        if(n > 9 && n < 27)
            return true;
        return false;
    }

    public void dfs(String s) {
        if(s.length() == 0) {
            count++;
            return;
        }

        if(s.charAt(0) - '0' > 0 && s.charAt(0) - '0' < 10) {
            numDecodings(s.substring(1, s.length()));
        }

        if(s.length() >= 2 && isValid(s.substring(0, 2))) {
            numDecodings(s.substring(2, s.length()));
        }
    }

    public int numDecodings(String s) {
        dfs(s);
        return count;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("06"));
    }
}
