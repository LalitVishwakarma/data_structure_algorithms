package Basic;

public class RemoveDuplicateFromSortedArray26 {
    public int removeDuplicate(int[] nums) {
        int j = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray26 obj = new RemoveDuplicateFromSortedArray26();
        int[] a = {1,2,2,3,3,3,4};
        System.out.println(obj.removeDuplicate(a));
    }

}
