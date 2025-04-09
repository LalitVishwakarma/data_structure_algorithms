package interviews;

public class CapitalOne {


    public static void main(String[] args) {

        String a = "001";
        String b = "010";

        int carry = 0;
        //sum

        int max = a.length() > b.length() ? a.length() : b.length();
        char[] res = new char[max+1];
        int index = 0;
        int i = a.length()-1;
        int j = b.length()-1;

//        System.out.println(max);
        while(i >= 0 && j >= 0) {
            int c = Integer.parseInt(a.substring(i, i+1));
            System.out.println(c);
            int d = Integer.parseInt(b.substring(j, j+1));
            System.out.println(d);
            if(c+d+carry  >= 2){
                res[index++] = (char)(c+d+carry - 2);
                carry = 1;
            } else {
                res[index++] = (char)(c+d+carry);
                carry = 0;
            }
            i--;
            j--;
        }
        if(i < 0){
            while(j >= 0){
                int e = Integer.parseInt(b.substring(j, j+1));
                if(carry == 1){
                    res[index++] = (char)(e+carry);
                    carry = 0;
                } else {
                    res[index++] = (char)(e+carry);
                }
                j--;
            }
        }
        if(j < 0){
            while(i >= 0){
                int e = Integer.parseInt(a.substring(i, i+1));
                if(carry == 1){
                    res[index++] = (char)(e+carry);
                    carry = 0;
                } else {
                    res[index++] = (char)(e+carry);
                }
                i--;
            }
        }
        if(carry == 1){
            res[index++] = (char)carry;
        }

        for(int k = 0; k < index; k++){
            System.out.println(res[k]);
        }
        String result = String.valueOf(res);

        System.out.println(result);
    }
}
