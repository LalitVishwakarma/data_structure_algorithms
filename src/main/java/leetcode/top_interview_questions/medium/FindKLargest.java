package leetcode.top_interview_questions.medium;

import java.util.Arrays;
import java.util.Random;

public class FindKLargest {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int[] nums, int left, int right, int pivot_index) {
        swap(nums, right, pivot_index);
        pivot_index = left;

        for(int j = left; j < right; j++) {
            if(nums[j] < nums[right]) {
                swap(nums, j, pivot_index);
                pivot_index++;
            }
        }
        swap(nums, pivot_index, right);
        return pivot_index;

    }
    public int quickSort(int[] nums, int left, int right, int k_smallest) {
        if(left == right)
            return nums[left];

        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left);

        pivotIndex = partition(nums, left, right, pivotIndex);

        if(pivotIndex < k_smallest) {
            return quickSort(nums, pivotIndex + 1, right, k_smallest);
        } else if(pivotIndex > k_smallest) {
            return quickSort(nums, left, pivotIndex - 1, k_smallest);
        }
        return nums[k_smallest];
    }
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }


    //2nd approach
    public int findKthLargestSecondApproach(int[] nums, int k) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for(int n : nums) {
            maxValue = Math.max(maxValue, n);
            minValue = Math.min(minValue, n);
        }

        int[] count = new int[maxValue - minValue + 1];
        Arrays.fill(count, 0);
        for(int n : nums) {
            count[n - minValue]++;
        }

        for(int i = count.length - 1; i >= 0; i--) {
            k-= count[i];
            if(k <= 0) {
                return minValue + i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};

        FindKLargest findKLargest = new FindKLargest();
        System.out.println(findKLargest.findKthLargestSecondApproach(nums, 4));
    }
}
