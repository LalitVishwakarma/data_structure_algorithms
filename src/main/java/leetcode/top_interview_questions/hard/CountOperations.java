package leetcode.top_interview_questions.hard;

public class CountOperations {
    public int minOperations(int n) {
        int operations = 0;

        while (n != 0) {
            if ((n & 1) == 0) {
                n >>= 1;  // just shifting (not counted)
            } else {
                if (n == 1) {
                    operations++;
                    break;
                }
                if ((n & 3) == 1) {
                    n -= 1;
                } else {
                    n += 1;
                }
                operations++;
            }
        }

        return operations;
    }
}
