package Challange500;

public class NumberOfIslands200 {
    boolean[][] visit = new boolean[300][300];
    int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void dfs(char[][] grid, boolean[][] visit, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visit[row][col] || grid[row][col] == '0')
            return;
        visit[row][col] = true;
        for(int[] DIRECTION : DIRECTIONS) {
            dfs(grid, visit, row + DIRECTION[0], col + DIRECTION[1]);
        }
    }


    public int numIslands(char[][] grid) {
        int nunOfIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visit[i][j] && grid[i][j] == '1') {
                    nunOfIslands++;
                    dfs(grid, visit, i, j);


                }
            }
        }
        return nunOfIslands;
    }

}


