package Basic;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        //Boyer-Moore Voting Algorithm
        int element = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                element = nums[i];
            }
            if(element == nums[i]) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        MajorityElement169 obj = new MajorityElement169();
        System.out.println(obj.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
