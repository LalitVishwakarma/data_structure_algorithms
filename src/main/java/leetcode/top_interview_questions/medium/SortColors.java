package leetcode.top_interview_questions.medium;

public class SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;

        int tmp;
        while(curr <= p2) {
            if(nums[curr] == 0) {
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                tmp = nums[p2];
                nums[p2--] = nums[curr];
                nums[curr++] = tmp;
            } else
                curr++;
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2,0,2,1,1,0};

        sortColors.sortColors(nums);
        System.out.println(nums);
    }
}
