package practice;

import java.util.*;

public class ElectricityConnectionGoogle {
    static class Edge {
        int x1, y1, x2, y2;

        Edge(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static List<int[]> buildElectricityNetwork(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        List<Edge> edges = new ArrayList<>();
        Map<Integer, List<int[]>> components = new HashMap<>();
        UnionFind uf = new UnionFind(rows * cols);

        // Build edges for all roads (1) and cities (-1)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 || grid[i][j] == -1) {
                    int current = i * cols + j;

                    // Right neighbor
                    if (j + 1 < cols && (grid[i][j + 1] == 1 || grid[i][j + 1] == -1)) {
                        int neighbor = i * cols + (j + 1);
                        edges.add(new Edge(i, j, i, j + 1));
                        uf.union(current, neighbor);
                    }

                    // Down neighbor
                    if (i + 1 < rows && (grid[i + 1][j] == 1 || grid[i + 1][j] == -1)) {
                        int neighbor = (i + 1) * cols + j;
                        edges.add(new Edge(i, j, i + 1, j));
                        uf.union(current, neighbor);
                    }
                }
            }
        }

        // Identify connected components (cities connected to roads)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 || grid[i][j] == -1) {
                    int root = uf.find(i * cols + j);
                    components.computeIfAbsent(root, k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }

        // Output list of used roads and cities
        List<int[]> result = new ArrayList<>();
        for (List<int[]> component : components.values()) {
            result.addAll(component);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, -1},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 1},
                {0, -1, 0, -1, 1, -1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1}
        };

        List<int[]> result = buildElectricityNetwork(grid);

        System.out.println("Electricity network:");

        int[][] grid1 = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };
        for (int[] cell : result) {
            grid1[cell[0]][cell[1]] = 1;
        }
        for (int[] row : grid1) {
            for (int val : row) {
                System.out.print(val  + " ");
            }
            System.out.println();
        }
    }
}