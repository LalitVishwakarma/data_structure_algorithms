package practice;

public class MaxSubArraySum {

    public static int maxSubArraySum(int[] nums) {
        int sum = 0;
        int max = nums[0];
        int i = 0;
        while(i < nums.length) {
            sum += nums[i];
            if(sum < 0) {
                sum = 0;
            }
            if(sum > max)
                max = sum;
            i++;
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(maxSubArraySum(a));
    }
}
