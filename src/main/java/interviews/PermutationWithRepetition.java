package interviews;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class PermutationWithRepetition {
    static int n;
    static int arr[] = new int[10];
    static int result[] = new int[10];

    public static void printResult() {
        for (int i = 0; i < n; i++){
            System.out.print(result[i]+ " ");
        }
        System.out.println();
    }
    public static void permutationWithRepetition(int number) {
        if(number >= n) {
            printResult();
            return;
        }

        for(int i = 0; i < n; i++){
            result[number] = arr[i];
            permutationWithRepetition(number + 1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //scanner
        Scanner sc = new Scanner(new File("resources/input/permutationWithRepetition.txt"));
        PrintStream o = new PrintStream(new File("resources/output/permutationWithRepetition.txt"));
        System.setOut(o);

        //number of test cases
        long numberOfTestCases = sc.nextLong();
        sc.nextLine();

        //run for each test case
        for (int currentTest = 0; currentTest < numberOfTestCases; currentTest++) {
            n = sc.nextInt();
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            permutationWithRepetition(0);
        }
    }
}
