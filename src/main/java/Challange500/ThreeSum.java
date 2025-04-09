package Challange500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Approach 1: Two Pointers
 * We will follow the same two pointers pattern as inTwo Sum II. It requires the array to be sorted, so we'll do that first. As our BCR isO(n
 * 2
 *  ), sorting the array would not change the overall time complexity.
 *
 * To make sure the result contains unique triplets, we need to skip duplicate values. It is easy to do because repeating values are next to each other in a sorted array.
 *
 * If you are wondering how to solve this problem without sorting the array, go over the"No-Sort"approach below. There are cases when that approach is preferable, and your interviewer may probe your knowledge there.
 *
 * After sorting the array, we move our pivot elementnums[i]and analyze elements to its right. We find all pairs whose sum is equal-nums[i]using the two pointers pattern, so that the sum of the pivot element (nums[i]) and the pair (-nums[i]) is equal to zero.
 *
 * As a quick refresher, the pointers are initially set to the first and the last element respectively.
 * We compare the sum of these two elements to the target. If it is smaller, we increment the lower pointerlo.
 * Otherwise, we decrement the higher pointerhi. Thus, the sum always moves toward the target, and we "prune"
 * pairs that would move it further away. Again, this works only if the array is sorted. Head to theTwo Sum
 * IIsolution for the detailed explanation.
 * */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) if (
                i == 0 || nums[i - 1] != nums[i]
        ) {
            twoSumII(nums, i, res);
        }
        return res;
    }

    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1]) ++lo;
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> res = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
        res.forEach(System.out::println);
    }
}
