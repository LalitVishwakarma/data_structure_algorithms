package leetcode.top_interview_questions.easy;

import java.util.Arrays;

public class HouseRobber {
    //DP with memoization
    private int[] memo;

    public int robDPWithMemoization(int[] nums) {
        this.memo = new int[100];

        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(this.memo, -1);

        return this.robFrom(0, nums);
    }

    private int robFrom(int i, int[] nums) {
        // No more houses left to examine.
        if (i >= nums.length) {
            return 0;
        }

        // Return cached value.
        if (this.memo[i] > -1) {
            return this.memo[i];
        }

        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(
                this.robFrom(i + 1, nums),
                this.robFrom(i + 2, nums) + nums[i]
        );

        // Cache for future use.
        this.memo[i] = ans;
        return ans;
    }


    //optimized DP approach
    public int robOptimizedDP(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return 0;

        int nextPlusOne = 0;
        int next = nums[n - 1];
        for(int i = n - 2; i >= 0; i++) {
            int curr = Math.max(nums[i] + nextPlusOne, next);
            nextPlusOne = next;
            next = curr;
        }

        return next;
    }

}
