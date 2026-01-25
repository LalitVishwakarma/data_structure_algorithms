package Basic;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    static int[][] MOVE = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) {
        int[][] a = {{1000, -1, 0, 1000}, {1000, 1000, 1000, -1}, {1000, -1, 1000, -1}, {0, -1, 1000, 1000}};
        int[][] result = getDistanceToGate(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(int[][] grid, int[][] visit, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || visit[i][j] == 1)
            return false;
        return true;
    }

    private static int[][] getDistanceToGate(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        int[][] visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visit[i], 0);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    visit[i][j] = 1;
                    queue.add(Pair.of(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
          Pair<Integer, Integer> node = queue.poll();
          for(int[] move : MOVE) {
              if(isValid(grid, visit, move[0] + node.getLeft(), move[1] + node.getRight())) {
                  visit[move[0] + node.getLeft()][move[1] + node.getRight()] = 1;
                  grid[move[0] + node.getLeft()][move[1] + node.getRight()] = grid[node.getLeft()][node.getRight()]+1;
                  queue.add(Pair.of(move[0] + node.getLeft(), move[1] + node.getRight()));
              }
          }
        }
        return grid;
    }
}

