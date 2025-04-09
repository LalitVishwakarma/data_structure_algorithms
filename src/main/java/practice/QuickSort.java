package practice;

public class QuickSort {
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        i++;
        swap(nums, end, i);
        return i;
    }

    public void quickSort(int[] nums, int start, int end) {
        if(start < end) {
            int mid = partition(nums, start, end);
            quickSort(nums, start, mid - 1);
            quickSort(nums, mid+1, end);

        }
    }


    public static void main(String[] args) {
        int[] input = {3, 7, 1, 10, 6};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(input, 0, input.length - 1);
        for (int i : input) {
            System.out.println(i);
        }
    }
}
