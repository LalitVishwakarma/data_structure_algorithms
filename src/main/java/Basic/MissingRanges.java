package Basic;

import java.util.ArrayList;
import java.util.List;

class MissingRanges {
    public static List<String> findMissingRanges(int[] nums, int left, int right) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            result.add(formatRange(left, right));
            return result;
        }
        int start = left;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != start && nums[i] - 1 >= left) {
                result.add(formatRange(start, nums[i] - 1));
            }
            start = nums[i] + 1;
        }
        if(nums[nums.length - 1] < right) {
            result.add(formatRange(start, right));
        }

        return result;
    }

    public static String formatRange(int start, int end) {
        return (start == end) ? String.valueOf(start) : start + "->" + end;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        List<String> result = findMissingRanges(nums, 0, 99);
        System.out.println(result);

    }
}
