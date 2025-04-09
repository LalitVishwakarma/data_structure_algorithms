package interviews;

import java.io.*;


public class PayPal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int desired_result = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());
        int[] powers = new int[n];
        for(int i_powers = 0; i_powers < n; i_powers++)
        {
            powers[i_powers] = Integer.parseInt(br.readLine());
        }

        int out_ = solve(desired_result, n, powers);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static int solve(int desired_result, int n, int[] powers){
        int element1 = powers[0];
        int element2  = powers[1];
        int diff = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < powers.length; i++) {
            for (int j = i + 1; j < powers.length; j++) {
                if (powers[i] > powers[j]) {
                    diff = powers[i] - powers[j];
                    if (diff > desired_result) {
                        if ((diff - desired_result) < minDiff) {
                            minDiff = diff - desired_result;
                            element1 = powers[i];
                            element2 = powers[j];
                        }
                    } else {
                        if ((desired_result - diff) < minDiff) {
                            minDiff = desired_result - diff;
                            element1 = powers[i];
                            element2 = powers[j];
                        }
                    }
                } else {
                    diff = powers[j] - powers[i];
                    if (diff > desired_result) {
                        if ((diff - desired_result) < minDiff) {
                            minDiff = diff - desired_result;
                            element1 = powers[i];
                            element2 = powers[j];
                        }
                    } else {
                        if ((desired_result - diff) < minDiff) {
                            minDiff = desired_result - diff;
                            element1 = powers[i];
                            element2 = powers[j];
                        }
                    }
                }
            }
        }
        return element1 + element2;
    }
}
