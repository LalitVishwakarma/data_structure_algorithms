package Basic;

public class MaximumSumSubarray {

    public static void main(String[] args) {
        MaximumSumSubarray maximumSumSubarray = new MaximumSumSubarray();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSumSubarray.getMaxSumSubarray(arr));
    }

    private int getMaxSumSubarray(int[] arr) {
        int sum = 0;
        int maxSum = 0;
        if (arr.length == 0)
            return 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
