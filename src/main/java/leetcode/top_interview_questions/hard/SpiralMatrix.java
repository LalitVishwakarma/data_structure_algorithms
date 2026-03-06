package leetcode.top_interview_questions.hard;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList();
        int top = 0, left = 0;
        int bottom = m - 1, right = n - 1;

        while(top <= bottom && left <= right) {
            int i = top;
            int j = left;
            while(j <= right) {
                result.add(matrix[i][j]);
                j++;
            }
            j--;
            top++;
            i++;
            while(i <= bottom) {
                result.add(matrix[i][j]);
                i++;
            }
            i--;
            right--;
            j--;
            while(j >= left) {
                result.add(matrix[i][j]);
                j--;
            }
            j++;
            bottom--;
            i--;
            while(i >= top) {
                result.add(matrix[i][j]);
                i--;
            }
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();

        List<Integer> result = spiralMatrix.spiralOrder(nums);
    }

}

