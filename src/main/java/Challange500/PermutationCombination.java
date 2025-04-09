package practice.LeetCode150BestSolutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class PermutationCombination {
    static int n;
    static int arr[] = new int[10];
    static int result[] = new int[10];
    static boolean visit[] = new boolean[10];

    public static void printResult() {
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void permutation(int number, int index) {
        if (number >= n) { // if 2 ppl to choose the (number >= 2)
            printResult();
            return;
        }

        for (int i = index; i < n; i++) { // for combination i will start from index
            if(!visit[i]) { // for repeat if condition will be removed
                visit[i] = true;
                result[number] = arr[i];
                permutation(number + 1, i+1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //scanner
        Scanner sc = new Scanner(new File("resources/input/permutation.txt"));
        PrintStream o = new PrintStream(new File("resources/output/permutation.txt"));
        System.setOut(o);

        //number of test cases
        long numberOfTestCases = sc.nextLong();
        sc.nextLine();

        //run for each test case
        for (int currentTest = 0; currentTest < numberOfTestCases; currentTest++) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            permutation(0, 0);
        }
    }
}