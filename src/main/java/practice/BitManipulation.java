package practice;

public class BitManipulation {

    public static void printBinary(int n) {
        for (int i = 10; i >= 0; i--) {
            System.out.print((n >> i) & 1);
        }
        System.out.println();
    }

    public static void evenOdd(int n) {
        if ((n&1) == 1) {
            System.out.println(n + " is odd");
        } else {
            System.out.println(n + " is even.");
        }
    }

    //left shift
    public static void multiplyBy2(int n) {
        System.out.println(n << 1);

    }
    //right shift
    public static void divideBy2(int n) {
        System.out.println(n >> 1);

    }

    //to lowercase
    //1<<5  ==> 32 ==> ' '
    public static void lowercase(char n) {
        System.out.println((char)(n | 1<<5));
        System.out.println((char)(n | ' ') );

    }
    //to uppercase
    //~(1<<5) ==> 1011111 ==> '_'
    public static void uppercase(char n) {
        System.out.println((char)(n & (~(1<<5))));
        System.out.println((char)(n & '_'));

    }

    //00000111011 ==> 00000100000
    public static void unsetILSB(int n, int i) {
        printBinary(n & (~((1 << (i+1)) - 1)));
    }

    //00000111011 ==> 00000001011
    public static void unsetIUSB(int n, int i) {
        printBinary(n & ((1 << (i+1)) - 1));
    }

    public static void isPowerOf2(int n) {
        if ((n & (n - 1)) == 0) {
            System.out.println(n + " is power of 2");
        } else {
            System.out.println(n + " is not power of 2");
        }

    }

    //XOR of same number is 0
    //XOR of number with 0 is number
    public static void swap(int a, int b) {
        System.out.println("a is " + a);
        System.out.println("b is " + b);

        a = a ^ b;
        b = b ^ a; // ==> b^(a^b) ==> b^b^a ==> 0 ^ a ==> a
        a = a ^ b; // ==> (a^b)^a ==> a^a^b ==> 0 ^ b =>> b

        System.out.println("a is " + a);
        System.out.println("b is " + b);
    }

    /**
     * given an array of n integers. All elements are present even number of times
     * except one, find that element in O(n) time and O(1) space complexity.
     * XOR of same number is 0
     * */
    public static int findElement(int[] a) {
        int result = 0;
        for(int i = 0; i < a.length; i++) {
            result = result ^ a[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 5;
        printBinary(n);

        evenOdd(n);

        multiplyBy2(n);

        divideBy2(n);

        lowercase('A');

        uppercase('a');

        unsetILSB(59, 4);

        unsetIUSB(59, 3);

        isPowerOf2(16);

        swap(12, 15);

        int[] a = {2,4,6,7,7,4,2,2,2};
        System.out.println("unique is " + findElement(a));
    }
}
