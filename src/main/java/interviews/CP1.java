package interviews;

public class CP1 {


    public static void main(String[] args) {

//        int[] arr = { -5,-4,-3,-2,-1};
//        int[] arr = { 1,3,4,5,6,7};
        int[] arr = { -5,-3, -1, 2, 4,  6};
//        // -1, 2, -3, 4, -5, 6
//        // 1, 4, 9, 16, 25, 36
//
//        -3, -1 2 4 -5, 6
//        2, -3,
//

//
//        for(int i =0; i < arr.length; i++){
//            for(int j = i; j < arr.length; j++){
//                int a = arr[i];
//                if(arr[i] < 0) a = -a;
//                int b = arr[j];
//                if(arr[j] < 0) b = -b;
//                if(a < b){
//                    int tmp = arr[i];
//                    arr[i] = arr[j];
//
//                }
//            }
//        }

        int pointer = 0;
        while (arr[pointer] < 0 && pointer < arr.length - 1){
            pointer++;
        }
        if(pointer < arr.length){
            int i = pointer-1;

            int[] result = new int[arr.length];
            int index = 0;

            while(i >= 0 && pointer <= arr.length - 1){
                int t = -arr[i];
                if(t < arr[pointer])
                    result[index++] = arr[i--];
                else
                    result[index++] = arr[pointer++];


            }
            if(i < 0){
                while (pointer <= arr.length - 1)
                    result[index++] = arr[pointer++];
            }
            if(pointer >= arr.length){
                while (i>=0){
                    result[index++] = arr[i--];
                }
            }

            for(int j =0; j < index; j++ ){
                System.out.println(result[j]);
            }
        } else {
            for(int j =0; j < arr.length; j++ ){
                System.out.println(arr[j]);
            }
        }

    }



}
