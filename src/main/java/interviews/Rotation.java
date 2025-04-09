package interviews;

import java.io.File;
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Rotation {
    static int n, r;
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */
        //Scanner
        Scanner sc = new Scanner(new File("resources/input/rotation.txt"));
        long T = sc.nextInt();
        for(long tc = 0; tc < T; tc++){
            n = sc.nextInt();
            r = sc.nextInt();
            r = r % n;
            long numbers[] = new long[n];
            for (int i = 0; i < n; i++){
                numbers[i] = sc.nextLong();
            }
            // int b[] = new int[n];
            // int j = 0;
            for (int i = n - r; i < n; i++){
                // b[j] = numbers[i];
                // j++;
                System.out.print(numbers[i] + " ");
            }
            for(int i = 0; i < n - r; i++) {
                // b[j] = numbers[i];
                // j++;
                System.out.print(numbers[i] + " ");
            }
            // for (int i = 0; i <n; i++){
            //     System.out.print(b[i] + " ");
            // }
            System.out.println();
        }

    }
}
