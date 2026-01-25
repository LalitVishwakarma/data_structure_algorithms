package Basic;

import java.util.Arrays;

class ThreeSumSmaller {
    public static int countTriplet(int[] nums, int target) {
        Arrays.sort(nums);

        int count = 0;
        int n = nums.length;

        for(int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;

            while(l < r) {
                if(nums[i] + nums[l] + nums[r] < target) {
                    count+=(r - l);
                    l++;
                } else {
                    r--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {-2, 0, 1, 3, -3};
        System.out.println(countTriplet(a, 2));
    }
}