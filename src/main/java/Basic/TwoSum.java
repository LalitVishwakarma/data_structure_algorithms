package Basic;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                int[] result = new int[2];
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = {2, 7, 11, 15};
        int[] r = twoSum.twoSum(arr, 9);
        System.out.println(r[0]);
        System.out.println(r[1]);
    }
}

