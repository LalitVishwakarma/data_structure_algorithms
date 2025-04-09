package interviews;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Permutation {
    static int n;
    static int arr[] = new int[10];
    static int result[] = new int[10];

    public static void printResult() {
        for (int i = 0; i < n; i++){
            System.out.print(result[i]+ " ");
        }
        System.out.println();
    }
    public static void permutation(int number, int index) {
        if(number >= n) {
            printResult();
            return;
        }

        for(int i = index; i < n; i++){
            result[number] = arr[i];
            permutation(number + 1, i + 1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //scanner
        Scanner sc = new Scanner(new File("resources/input/permutation.txt"));
        PrintStream o = new PrintStream("resources/output/permutation.txt");
        System.setOut(o);

        //number of test cases
        long numberOfTestCases = sc.nextLong();
        sc.nextLine();

        //run for each test case
        for (int currentTest = 0; currentTest < numberOfTestCases; currentTest++) {
            n = sc.nextInt();
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            permutation(0, 0);
        }
    }
}
