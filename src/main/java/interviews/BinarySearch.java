package interviews;

public class BinarySearch {

    static int binarySearch(int[] arr, int start, int end, int data){
        int mid = (start + end) / 2;
        System.out.println(mid);
        if(arr[mid] == data)
            return mid;
        else if(data > arr[mid]){
            return binarySearch(arr, mid + 1, end, data);
        } else {
            return binarySearch(arr, start,mid - 1, data);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr, 0, 9, 6));
    }
}
