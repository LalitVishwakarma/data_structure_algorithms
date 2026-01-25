package Challange500;

import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        for(int i = 0; i < nums.length - 2; i++) {
            if(set.contains(diff + nums[i]) && set.contains((2 * diff) + nums[i])){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfArithmeticTriplets numberOfArithmeticTriplets = new NumberOfArithmeticTriplets();
        int[] arr = {0,1,4,6,7,10};
        System.out.println(numberOfArithmeticTriplets.arithmeticTriplets(arr, 3));
    }

}
