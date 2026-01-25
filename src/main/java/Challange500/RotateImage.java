package Challange500;


/*
Approach 2: Reverse on the Diagonal and then Reverse Left to Right
Intuition

The most elegant solution for rotating the matrix is to first reverse the matrix around the main diagonal,
and then reverse it from left to right. These operations are called transpose and reflect in linear algebra.

* **/


import java.util.Arrays;

public class RotateImage {

    public int[][] rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] result = new int[n][m];

        //transpose
        for(int i= 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        //reverse each row
        for(int i = 0; i < n; i++) { //rows
            for(int j = 0; j < m / 2; j++) { //columns
                int temp = result[i][j];
                result[i][j] = result[i][m-1-j];
                result[i][m - 1 - j] = temp;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        RotateImage rotateImage = new RotateImage();
        int[][] res = rotateImage.rotate(matrix);
        System.out.println(Arrays.deepToString(res));
    }
}
