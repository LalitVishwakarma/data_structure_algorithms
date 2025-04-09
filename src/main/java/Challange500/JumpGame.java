package Challange500;
import java.util.Arrays;
/**
Approach 2: Dynamic Programming Top-down
Top-down Dynamic Programming can be thought of as optimized backtracking. It relies on the observation
that once we determine that a certain index is good / bad, this result will never change. This means that we
can store the result and not need to recompute it every time.

Therefore, for each position in the array, we remember whether the index is good or bad. Let's call this
array memo and let its values be either one of: GOOD, BAD, UNKNOWN. This technique is called memoization3.

An example of a memoization table for input array nums = [2, 4, 2, 1, 0, 2, 0] can be seen in the diagram below.
We write G for a GOOD position and B for a BAD one. We can see that we cannot start from indices 2, 3 or 4 and
eventually reach last index (6), but we can do that from indices 0, 1, 5 and (trivially) 6.

* **/
public class JumpGame {
    public boolean canJump(int[] nums, int[] jump, int index) {
        if(index > nums.length - 1)
            return false;
        if(jump[index] != 2)
            return jump[index] == 0;

        for(int i = 1; i <= nums[index]; i++) {
            if(canJump(nums, jump, index + i)){
                jump[index] = 0;
                return true;
            }
        }
        jump[index] = 1;
        return false;
    }

    public boolean canJump(int[] nums) {
        int[] jump = new int[nums.length];
        Arrays.fill(jump, 2);
        jump[nums.length - 1] = 0;
        return canJump(nums, jump, 0);
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[] {2,3,1,1,4}));
    }

    /**
     * Best Approach: Greedy
     * Once we have our code in the bottom-up state, we can make one final, important observation.
     * From a given position, when we try to see if we can jump to a GOOD position, we only ever use one -
     * the first one (see the break statement). In other words, the left-most one. If we keep track of this
     * left-most GOOD position as a separate variable, we can avoid searching for it in the array. Not only that,
     * but we can stop using the array altogether.
     *
     * Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index
     * (currPosition + nums[currPosition] >= leftmostGoodIndex). If we can reach a GOOD index, then our position is itself GOOD.
     * Also, this new GOOD position will be the new leftmost GOOD index. Iteration continues until the beginning of the array.
     * If first position is a GOOD index then we can reach the last index from the first position.
     *
     * To illustrate this scenario, we will use the diagram below, for input array nums = [9, 4, 2, 1, 0, 2, 0].
     * We write G for GOOD, B for BAD and U for UNKNOWN. Let's assume we have iterated all the way to position 0 and
     * we need to decide if index 0 is GOOD. Since index 1 was determined to be GOOD, it is enough to jump there and
     * then be sure we can eventually reach index 6. It does not matter that nums[0] is big enough to jump all the
     * way to the last index. All we need is one way.

     public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
     }
     * */
}
