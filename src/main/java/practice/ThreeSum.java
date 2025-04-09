package practice;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // for(int l : nums)
        //     System.out.println(l + " ");
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i < nums.length - 1; i++) {
            // System.out.print("i " + i);
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                // System.out.print(" j " + j);
                // System.out.println(" k " + k);
                if(nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[j]);
                    r.add(nums[k]);
                    result.add(r);
                    j++;
                    k--;
                } else if(nums[i] + nums[j] + nums[k] < 0)
                    j++;
                else
                    k--;
            }
        }
        return new ArrayList<>(result);

    }
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }
}
