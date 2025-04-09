package interviews;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TheUnlucky13 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("resources/practice.interviews.TheUnlucky13.txt"));
        long numberOfTestCases = sc.nextLong();
        for (int currentTest = 0; currentTest < numberOfTestCases; currentTest++) {
            int n = sc.nextInt();
            System.out.println(n);
        }
    }
}
