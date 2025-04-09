package interviews;

public class SortArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        int[] result = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                result[index++] = arr1[i++];
            } else{
                result[index++] = arr2[j++];
            }
        }
        if(i >= arr1.length){
            while (j < arr2.length){
                result[index++] = arr2[j++];
            }
        }

        if(j >= arr2.length){
            while (i < arr1.length){
                result[index++] = arr1[i++];
            }
        }

        for(int k = 0; k < result.length; k++){
            System.out.print(result[k] + " ");
        }

    }
}
