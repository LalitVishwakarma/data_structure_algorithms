package Basic;

import org.apache.commons.lang3.tuple.Pair;

public class DivideAndConcur {
    public Pair<Integer, Integer> findMinAndMax(int[] nums, int left, int right) {
            if(left == right) {
                return Pair.of(nums[left], nums[right]);
            }
            if(left + 1 == right) {
                if (nums[left] < nums[right]) {
                    return Pair.of(nums[left], nums[right]);
                } else {
                    return Pair.of(nums[right], nums[left]);
                }
            }
            int mid = (left + right) / 2;
            Pair<Integer, Integer> subResultLeft = findMinAndMax(nums, left, mid);
            Pair<Integer, Integer> subResultRight = findMinAndMax(nums, mid + 1, right);

            return Pair.of(subResultLeft.getLeft() < subResultRight.getLeft() ? subResultLeft.getLeft() : subResultRight.getLeft(),
                    subResultLeft.getRight() > subResultRight.getRight() ? subResultLeft.getRight() : subResultRight.getRight());

    }

    public int powerOfElement(int number, int power) {
        if(power == 1)
            return number;
        int mid = power / 2;
        int subSolution = powerOfElement(number, mid);
        if (power % 2 == 0) {
            return subSolution * subSolution;
        }
        // if power is odd
        return subSolution * subSolution * number;
    }

    public int binarySearch(int[] nums, int left, int right, int x) {
            if(left == right) {
                return nums[left] == x ? left : -1;
            }

            int mid = (left + right) / 2;
            if (nums[mid] == x)
                return mid;
            if (nums[mid] > x)
                return binarySearch(nums, left, mid - 1, x);
            return binarySearch(nums, mid + 1, right, x);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left == right)
            return;

        int mid = (left + right) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if(nums[i] < nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }
        if(i > mid) {
            while (j <= right) {
                temp[index++] = nums[j++];
            }
        }

        if(j > right) {
            while (i <= mid) {
                temp[index++] = nums[i++];
            }
        }
        for (int l = left, k = 0; l <= right; l++, k++) {
            nums[l] = temp[k];
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        i++;
        swap(nums, i, right);
        return i;
    }

    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        DivideAndConcur divideAndConcur = new DivideAndConcur();
        int[] nums = {42, 7, 89, 23, 5, 90, 12};
        Pair<Integer, Integer> result = divideAndConcur.findMinAndMax(nums, 0, nums.length - 1);
        System.out.println("Min is: " + result.getLeft());
        System.out.println("Max is: " + result.getRight());

        System.out.println(divideAndConcur.powerOfElement(2, 5));

        int[] sortedArray = {1, 3, 5, 7, 9, 11, 15};
        System.out.println(divideAndConcur.binarySearch(sortedArray, 0, sortedArray.length - 1, 9));

//        divideAndConcur.quickSort(nums, 0, nums.length - 1);
        divideAndConcur.bubbleSort(nums);
        for (int n : nums){
            System.out.println(n);
        }


    }
}
