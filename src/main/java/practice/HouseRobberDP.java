package practice;

public class HouseRobberDP {
    public int dp(int[] nums, int[] dp1, int index) {
        if(index < 0)
            return 0;
        if(dp1[index] > -1)
            return dp1[index];
        dp1[index] = Math.max(dp(nums, dp1, index - 2) + nums[index], dp(nums, dp1, index - 1));
        return dp1[index];
    }
    public int rob(int[] nums) {
        int[] dp1 = new int[nums.length + 1];
        for(int i = 0; i <= nums.length; i++){
            dp1[i] = -1;
        }

        return dp(nums, dp1, nums.length - 1);
    }

    public static void main(String[] args) {
        HouseRobberDP houseRobberDP = new HouseRobberDP();
        int[] nums = {6,6,4,8,4,3,3,10};
        System.out.println(houseRobberDP.rob(nums));
    }

}
