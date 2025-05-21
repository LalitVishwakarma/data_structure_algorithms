package Challange500;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * Example 1:
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 * Constraints:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 * */

public class DegreeOfArray697 {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap();
        Map<Integer, Integer> start = new HashMap();
        Map<Integer, Integer> end = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count.put(num, count.getOrDefault(num, 0) + 1);
            if(!start.containsKey(num)){
                start.put(num, i);
            }
            end.put(num, i);
        }

        int degree = Collections.max(count.values());

        int len = nums.length;

        for(int i : count.keySet()) {
            if(count.get(i) == degree) {
                len = Math.min(len, end.get(i) - start.get(i) + 1);
            }
        }
        return len;

    }

    public static void main(String[] args) {
        int[] a = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(a));
    }
}
