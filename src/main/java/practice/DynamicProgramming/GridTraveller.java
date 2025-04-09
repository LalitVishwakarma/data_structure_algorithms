package practice.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    static int gridTravellerWithMemorisation(int row, int column, Map<String, Integer> map) {
        if(map.containsKey(row + ","+ column))
            return map.get(row + ","+ column);
        if(row <= 0 || column <= 0) return 0;
        if(row == 1 && column == 1) return 1;

        int temp = gridTravellerWithMemorisation(row-1, column, map) + gridTravellerWithMemorisation(row, column-1, map);
        map.put(row + ","+ column, temp);
        return temp;
    }

    static int gridTravellerWithTabulation(int row, int column) {
        int[][] table = new int[row+1][column+1];
//        Arrays.fill(table, 0);
        for(int i = 0; i <= row; i++)
            for(int j = 0; j <= column; j++)
                table[i][j] = 0;
        table[1][1] = 1;
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= column; j++) {
                if(i+1<=row) table[i+1][j] += table[i][j];
                if(j+1<=column) table[i][j+1] += table[i][j];
            }
        }
        for(int i = 0; i < row+1; i++) {
            for (int j = 0; j < column + 1; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return table[row][column];
    }

    public static void main(String[] args) {

//        System.out.println(gridTravellerWithMemorisation(4,4, new HashMap<String, Integer>()));
        System.out.println(gridTravellerWithMemorisation(20,20, new HashMap<String, Integer>()));

//        System.out.println(gridTravellerWithTabulation(4,4));
//        System.out.println(gridTravellerWithTabulation(20,20));
    }
}