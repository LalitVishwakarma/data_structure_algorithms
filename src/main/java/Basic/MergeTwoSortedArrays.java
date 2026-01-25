package Basic;

public class MergeTwoSortedArrays {
    public int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int m = 0;
        int n = 0;
        int index = 0;
        while(m < a.length && n < b.length) {
            if(a[m] < b[n]) {
                result[index++] = a[m++];
            } else {
                result[index++] = b[n++];
            }
        }
        if(m >= a.length) {
            while( n < b.length) {
                result[index++] = b[n++];
            }
        }
        while (m < a.length) {
            result[index++] = a[m++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9};
        int[] b = {2,4,6,8,10};
        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        int[] r = mergeTwoSortedArrays.merge(a, b);
        for (int j : r) {
            System.out.println(j);
        }
    }
}

