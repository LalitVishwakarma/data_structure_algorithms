//package leetcode.top_interview_questions.medium;
//
//public class SearchInRotatedSortedArray {
//    public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//
//        while(left < right) {
//            int mid = left + (right - left) / 2;
//            if(nums[mid] == target) {
//                return mid;
//            } else if(nums[left] < nums[mid - 1]) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        System.out.println(left);
//        return nums[left] == target ? left : -1;
//    }
//
//    public static void main(String[] args) {
//        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
//        int[] nums = {4,5,6,7,0,1,2};
//        System.out.println(obj.search(nums, 0));
//    }
//}
