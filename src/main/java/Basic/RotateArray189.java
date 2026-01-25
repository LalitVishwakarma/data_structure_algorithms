package Basic;

public class RotateArray189 {
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public void rotate(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        RotateArray189 obj = new RotateArray189();
        int[] a = new int[]{1,2,3,4,5,6,7,8,9, 0};
        obj.rotate(a, 4);
        for(int n : a){
            System.out.println(n);
        }
    }
}
