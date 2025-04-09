package Challange500;


/*
Approach 2: Reverse on the Diagonal and then Reverse Left to Right
Intuition

The most elegant solution for rotating the matrix is to first reverse the matrix around the main diagonal,
and then reverse it from left to right. These operations are called transpose and reflect in linear algebra.

* **/


import java.util.Arrays;

public class RotateImage {

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for(int i= 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int i= 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
