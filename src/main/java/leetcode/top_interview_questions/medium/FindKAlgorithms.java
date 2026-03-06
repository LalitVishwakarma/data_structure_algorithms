package leetcode.top_interview_questions.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FindKAlgorithms {

    /**
     * 347. Top K Frequent Elements
     * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
     * Example 1: Input: nums = [1,1,1,2,2,3], k = 2, Output: [1,2]
     * Example 2: Input: nums = [1], k = 1, Output: [1]
     * Example 3: Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2, Output: [1,2]
     * Constraints:
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * k is in the range [1, the number of unique elements in the array].
     * It is guaranteed that the answer is unique.
     * */
    Map<Integer, Integer> count = new HashMap();
    int[] unique;
    public void swap(int i, int j) {
        int temp = unique[i];
        unique[i] = unique[j];
        unique[j] = temp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot = unique[pivot_index];
        int pivot_frequency = count.get(pivot);

        swap(right, pivot_index);
        int store_index = left;

        for(int i = left; i < right; i++) {
            if(count.get(unique[i]) < pivot_frequency) {
                swap(store_index++, i);
            }
        }
        swap(store_index, right);
        return store_index;
    }

    public void quickSelect(int left, int right, int k_smallest) {
        if(left == right)
            return;
        //Select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        pivot_index = partition(left, right, pivot_index);
        if (k_smallest < pivot_index) {
            quickSelect(left, pivot_index - 1, k_smallest);
        } else if (k_smallest > pivot_index){
            quickSelect(pivot_index + 1, right, k_smallest);
        }
    }


    public int[] topKFrequent(int[] nums, int k) {
        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        int n = count.size();
        unique = new int[n];

        int index = 0;
        for(Integer key : count.keySet()) {
            unique[index++] = key;
        }

        quickSelect(0, count.size() - 1, n - k);

        return Arrays.copyOfRange(unique, n - k, n);
    }


    /**
     * Given an integer array nums and an integer k, return the k least frequent elements in the array.
     * You may return the answer in any order.
     * Example 1: Input:  nums = [1,1,1,2,2,3], k = 2, Output: [3,2]
     * */
    public int[] bottomKFrequent(int[] nums, int k) {
        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        int n = count.size();
        unique = new int[n];

        int index = 0;
        for(Integer key : count.keySet()) {
            unique[index++] = key;
        }

        quickSelect(0, count.size() - 1, k);

        return Arrays.copyOfRange(unique, 0, k);
    }
    public static void main(String[] args) {
        FindKAlgorithms findKAlgorithms = new FindKAlgorithms();

        int[] nums = {1,1,1,2,2,3,3,4,5,5,5,5};

//        int[] topKFrequent = findKAlgorithms.topKFrequent(nums, 3);
        int[] bottomKFrequent = findKAlgorithms.bottomKFrequent(nums, 3);
        for (int i : bottomKFrequent){
            System.out.print(i + " ");
        }
    }
}

