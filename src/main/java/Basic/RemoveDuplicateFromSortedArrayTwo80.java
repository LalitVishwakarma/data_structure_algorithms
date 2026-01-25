package Basic;

public class RemoveDuplicateFromSortedArrayTwo80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        boolean isTwice = false;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[++i] = nums[j];
                isTwice = false;
            } else if (!isTwice) {
                nums[++i] = nums[j];
                isTwice = true;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArrayTwo80 obj = new RemoveDuplicateFromSortedArrayTwo80();
        int[] a = {1,1,1,2,2,3};
        System.out.println(obj.removeDuplicates(a));
    }
}
