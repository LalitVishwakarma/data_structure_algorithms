package interviews;

public class Walmart2 {

    public static void main(String[] args) {
        int[] array = { 0, 1, 2, 1, 0, 1 };

            // 0 0 1 1 1 2
        int cointZero= 0;
        int cointOne = 0;
        int cointTwo = 0;

        int pointerOne = 0;
        int pointer2 = array.length - 1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                array[pointerOne++] = 0;
            }
            if(array[i] == 2){
                if(array[pointer2] == 0){
                    array[pointerOne++] = 0;
                }
                array[pointer2--] = 2;
            }
        }
        for(int i = pointerOne - 1; i <= pointer2 + 1; i++){
            array[i] = 1;
        }


        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

}
