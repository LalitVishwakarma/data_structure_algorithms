package Challange500;

/* Question -
Given an array of integers nums, find the next permutation of nums.
The replacement must be in place and use only constant extra memory.

Approach 2: Single Pass Approach
Algorithm

First, we observe that for any given sequence that is in descending order, no next larger permutation is possible.
For example, no next permutation is possible for the following array:

[9, 5, 4, 3, 1]
We need to find the first pair of two successive numbers a[i]and a[i−1], from the right, which satisfy
a[i]>a[i−1]. Now, no rearrangements to the right ofa[i−1]can create a larger permutation since that sub array consists of numbers in descending order.
Thus, we need to rearrange the numbers to the right ofa[i−1]including itself.

Now, what kind of rearrangement will produce the next larger number? We want to create the permutation just larger than the current one.
Therefore, we need to replace the numbera[i−1]with the number which is just larger than itself among the numbers lying to its right section, saya[j].

We swap the numbersa[i−1]anda[j]. We now have the correct number at indexi−1. But still the current permutation isn't the permutation
that we are looking for. We need the smallest permutation that can be formed by using the numbers only to the right ofa[i−1]. Therefore, we need to place those
numbers in ascending order to get their smallest permutation.

But, recall that while scanning the numbers from the right, we simply kept decrementing the index
until we found the paira[i]anda[i−1]where,a[i]>a[i−1]. Thus, all numbers to the right ofa[i−1]were already sorted in descending order.
Furthermore, swappinga[i−1]anda[j]didn't change that order.
Therefore, we simply need to reverse the numbers followinga[i−1]to get the next smallest lexicographic permutation.

* **/

import java.util.Arrays;

public class NextPermutation {
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void nextPermutation (int[] nums) {
        int i = nums.length - 2;

        while(i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        //if we dont need to reverse whole array
        if(i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] arr = {1,2,3};
        nextPermutation.nextPermutation(arr);
//        System.out.println(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
