package Challange500;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int start = lower;
        for(int i = 0; i < nums.length; i++) {
            if(start < nums[i]) {
                List<Integer> r = new ArrayList();
                r.add(start);
                r.add(nums[i] - 1);
                result.add(r);
            }
            start = nums[i] + 1;
        }
        if(start <= upper) {
            List<Integer> r = new ArrayList();
            r.add(start);
            r.add(upper);
            result.add(r);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0, upper = 99;
        MissingRanges missingRanges = new MissingRanges();
        missingRanges.findMissingRanges(nums, lower, upper).forEach(System.out::println);
    }
}