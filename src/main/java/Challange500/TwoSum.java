package Challange500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Approach 3: One-pass Hash Table
//        Algorithm
//
//It turns out we can do it in one-pass. While we are iterating and inserting elements into the hash table,
// we also look back to check if current element's complement already exists in the hash table. If it exists,
// we have found a solution and return the indices immediately.

//Complexity Analysis
//
//Time complexity: O(n).
//We traverse the list containing n elements only once. Each lookup in the table costs only O(1) time.
//
//Space complexity: O(n).
//The extra space required depends on the number of items stored in the hash table, which stores at most n elements.

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;

    }

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();
        int[] arr = {2,7,11,15};
        Arrays.stream(twoSum.twoSum(arr, 9)).forEach(System.out::println);
    }

}
