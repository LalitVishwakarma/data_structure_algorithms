package Challange500;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int index = digits.length - 1;
        while(carry > 0 && index >= 0) {
            int sum = digits[index] + carry;
            carry = sum / 10;
            digits[index] = sum % 10;
            index--;
        }
        if(index < 0 && carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for(int i = 0; i < digits.length; i++)
                result[i+1] = digits[i];
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] r = plusOne.plusOne(new int[] {9});
        System.out.println(Arrays.toString(r));
    }
}
