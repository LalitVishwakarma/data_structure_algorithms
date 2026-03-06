//package leetcode.top_interview_questions.medium;
//
//public class Flatten2DVector {
//    int[][] vector;
//    int row;
//    int col;
//    public Vector2D(int[][] vec) {
//        vector = vec;
//        row = 0;
//        col = 0;
//    }
//
//    public int next() {
//        if(hasNext()) {
//            int r = vector[row][col];
//            if(col == vector[row].length - 1) {
//                row++;
//                col = 0;
//            } else {
//                col++;
//            }
//            return r;
//        }
//        return -1;
//    }
//
//    public boolean hasNext() {
//        return row < vector.length && col < vector[row].length - 1;
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
