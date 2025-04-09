package Challange500;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1]
and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.


* **/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSorted {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[] {left, right};
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else
                left++;
        }
        return new int[] {-1, -1};

    }

    public static void main(String[] args) {

        TwoSumSorted twoSum = new TwoSumSorted();
        int[] arr = {2,7,11,15};
        Arrays.stream(twoSum.twoSum(arr, 9)).forEach(System.out::println);
    }
}
