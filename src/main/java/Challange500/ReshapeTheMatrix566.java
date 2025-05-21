package Challange500;
/*
In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
Example 1:
Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
Example 2:
Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]
**/
public class ReshapeTheMatrix566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m*n == r*c) {
            int[][] result = new int[r][c];
            int index = 0;
            while(index < m*n) {
                result[index / c][index % c] = mat[index / n][index % n];
                index++;
            }
            return result;
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2}, {3,4}};
        ReshapeTheMatrix566 reshapeTheMatrix566 = new ReshapeTheMatrix566();
        int[][] result = reshapeTheMatrix566.matrixReshape(arr, 1, 4);
        for(int[] row: result) {
            for (int val : row) {
                System.out.println(val);
            }
        }
    }
}
