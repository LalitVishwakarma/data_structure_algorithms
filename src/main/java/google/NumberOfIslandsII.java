package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {
    int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int count;

    private class Union {
        int[] parent;
        int[] rank;

        Union(int n){
            parent = new int[n];
            Arrays.fill(parent, -1);
            rank = new int[n];
        }

        public void add(int x) {
            parent[x] = x;
        }

        public int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if(px == py)
                return false;

            if(rank[px] < rank[py]) {
                parent[px] = py;
            } else if(rank[px] > rank[py]){
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList();
        Union union = new Union(m * n);

        boolean[] visit = new boolean[m * n];

        Arrays.fill(visit, false);

        for(int[] position : positions) {
            int row = position[0];
            int col = position[1];

            if(visit[row * n + col]){
                result.add(count);
                continue;
            }

            visit[row * n + col] = true;
            union.add(row * n + col);
            count++;

            for(int[] DIRECTION : DIRECTIONS) {
                int neighbourRow = row + DIRECTION[0];
                int neighbourCol = col + DIRECTION[1];

                if(neighbourRow < 0 || neighbourRow >= m || neighbourCol < 0 || neighbourCol >= n) {
                    continue;
                }

                if(visit[neighbourRow * n + neighbourCol] && union.union(row * n + col, neighbourRow * n + neighbourCol)) {
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfIslandsII numberOfIslandsII = new NumberOfIslandsII();

        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};

        System.out.println(numberOfIslandsII.numIslands2(3, 3, positions));
    }
}
