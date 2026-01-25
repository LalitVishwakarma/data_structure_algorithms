package leetcode.top_interview_questions.easy;

public class ValidSudoku {
    public boolean isRowValid(char[][] board, int row, int column) {
        if(board[row][column] == '.')
            return true;

        for(int j = 0; j < board[0].length; j++) {
            if(j != column && board[row][column] == board[row][j]) {
                System.out.println("row: " + row + " column: " + column);
                System.out.println("i: " + row + " column: " + j);
                return false;
            }
        }
        return true;
    }
    public boolean isColumnValid(char[][] board, int row, int column) {
        if(board[row][column] == '.')
            return true;

        for(int i = 0; i < board.length; i++) {
            if(i != row && board[row][column] == board[i][column]) {
                System.out.println("row: " + row + " column: " + column);
                System.out.println("i: " + i + " j: " + column);
                return false;
            }
        }
        return true;
    }
    public boolean isgridValid(char[][] board, int row, int column) {

        if(board[row][column] == '.')
            return true;
        int grid_row = (row / 3) * 3;
        int grid_column = (column / 3) * 3;
        for(int i = grid_row; i < grid_row + 3; i++) {
            for(int j = grid_column; j < grid_column + 3; j++) {
                if(i != row && j != column && board[row][column] == board[i][j]) {
                    System.out.println("row: " + row + " column: " + column);
                    System.out.println("i: " + i + " j: " + j);
                    return false;
                }

            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(!(isRowValid(board, i, j) && isColumnValid(board, i, j) && isgridValid(board, i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(board));
    }
}
