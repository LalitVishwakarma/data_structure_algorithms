package Challange500;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
Approach 1
Multiplication of both numbers starts from the ones place digit (the right-most digit),
so we should start our multiplication from index num2.size() - 1 and go to index 0.
Alternatively, we can reverse both inputs and iterate from index 0 to index num2.size() - 1.

For each digit in num2 that we multiply by num1 we will get a new intermediate result.
This intermediate result (currentResult) will be stored in a list, string, or StringBuilder,
depending on the language of choice. To calculate each intermediate result, we will start by
inserting the appropriate number of zeros according to the current digit's place in the second
number (i.e. if it is the hundreds place, we append 2 zeros). Then we will perform the multiplication
step as demonstrated in the above diagrams. During this step, we will insert the lower place digits into
the currentResult before the higher place digits. Because we are pushing the lower place digits first and
always appending to the end, our result will be in reverse order, so once the multiplication and addition
steps are complete, we will need to reverse answer before returning.

Approach 2
Sum the products from all pairs of digits
Intuition
As we have seen in the previous approaches, when we multiply two digits, one from the first number and one from the second number,
then their product will have some zeros appended at the end. The number of zeros depends on the place of each digit,
and (as demonstrated in the image below) when the result is added to the answer,
the trailing zeros do not affect the answer (because any number plus zero is itself).
So it is not necessary for us to append zeros at the end of each result before adding the result to the final answer.
Instead, we can directly add the multiplication result at the place where the least significant digit will shift
to after to appending some zeros.

As an example, when we multiply two tens place digits, two zeros are appended at the end of the multiplication result,
and the result will be added at the hundreds place in the final answer. One more example for clarity,
if we multiplied a digit in the thousands place (3 trailing zeros) by a digit in the hundreds place (2 trailing zeros),
the product will have 5 trailing zeros (the sum of trailing zeros of each digit)
so the result will only affect the hundred thousands place and the millions place in the final answer.
* **/
import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
    public String multiplyApproach1(String num1, String num2) {
        char[] first = num1.toCharArray();
        char[] second = num2.toCharArray();
        int carry = 0;
        List<List<Integer>> result = new ArrayList();
        for(int i = first.length - 1; i >=0; i--) {
            carry = 0;
            char firstToDigit = first[i];
            int k = 0;
            List<Integer> row = new ArrayList();
            while(k < first.length - 1 - i){
                row.add(0);
                k++;
            }
            for(int j = second.length - 1; j >= 0; j--) {
                int multiplication = (firstToDigit - '0') * (second[j] - '0') + carry;
                carry = multiplication / 10;
                row.add(multiplication % 10);
            }
            if(carry > 0) {
                row.add(carry);
                carry = 0;
            }
            result.add(row);
        }

        List<Integer> sum = new ArrayList();
        for(int i = 0; i < result.get(first.length - 1).size(); i++) {
            int sumTemp = carry;
            for(int j = 0; j < result.size(); j++) {
                if(i < result.get(j).size()) {
                    sumTemp += result.get(j).get(i);
                }
            }
            carry = sumTemp / 10;
            sum.add(sumTemp % 10);
        }
        if(carry > 0)
            sum.add(carry);
        String r = "";
        for(int i = 0; i < sum.size(); i++){
            r = "" + sum.get(i) + r;
        }
        return r;
    }

    public String multiplyApproach2(String num1, String num2) {
        char[] first = num1.toCharArray();
        char[] second = num2.toCharArray();
        int carry = 0;
        List<List<Integer>> result = new ArrayList();
        for(int i = first.length - 1; i >=0; i--) {
            for(int j = second.length - 1; j >= 0; j--) {
                int k = 0;
                List<Integer> row = new ArrayList();
                while(k < first.length - i + second.length - j - 2){
                    row.add(0);
                    k++;
                }
                int multiplication = (first[i] - '0') * (second[j] - '0') + carry;
                carry = multiplication / 10;
                row.add(multiplication % 10);
                if(carry > 0) {
                    row.add(carry);
                    carry = 0;
                }
                result.add(row);
            }

        }

        List<Integer> sum = new ArrayList<>();
        for(int i = 0; i <  result.get(result.size() - 1).size(); i++) {
            int sumTemp = carry;
            for(int j = 0; j < result.size(); j++) {
                if(i < result.get(j).size()) {
                    sumTemp += result.get(j).get(i);

                }
            }
            carry = sumTemp / 10;
            sum.add(sumTemp % 10);
        }
        if(carry > 0)
            sum.add(carry);
        String r = "";
        for(int i = 0; i < sum.size(); i++){
            r = "" + sum.get(i) + r;
        }
        return r;
    }


    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiplyApproach2("1", "5"));
    }
}



