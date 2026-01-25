package Basic;

public class MergeTwoSortedArraysInPlace {
    public static void merge(int[] a, int m, int[] b, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m+ n - 1;

        while(i >= 0 && j >= 0) {
            if(a[i] > b[j]) {
                a[index--] = a[i--];
            } else {
                a[index--] = b[j--];

            }
        }
        while(j >= 0) {
            a[index--] = b[j--];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,5,6};
        merge(a, 3, b, 3);
        for(int i : a) {
            System.out.println(i);
        }
    }
    
}
