package practice.DynamicProgramming;

public class SumOfSubstrings {

    static int sumOfSubString(String num){
        int n = num.length();

        System.out.println(num.charAt(1));
        // allocate memory equal to length of string
        int sumofdigit[] = new int[n];

        // initialize first value with first digit
        sumofdigit[0] = num.charAt(0) - '0';
        int res = sumofdigit[0];

        // loop over all digits of string
        for (int i = 1; i < n; i++) {
            int numi = num.charAt(i) - '0';

            // update each sumofdigit from previous value
            sumofdigit[i] = (i + 1) * numi + 10 * sumofdigit[i - 1];

            // add current value to the result
            res += sumofdigit[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(sumOfSubString("1234"));
    }
}
